(ns brew-bot.recipe-generation.util
  "Common fns required across recipe generation strategies"
  (:require [bigml.sampling.simple :as bss]
            [brew-bot.recipe-generation.ingredients :as ingredients]))

(defn rand-key
  "Pick a random key from a map, weighted by the :probability key of the value"
  [m]
  (first (bss/sample (keys m) :replace true :weigh #(or (:probability (get m %)) 1))))

(defn join-ingredient-maps
  "Given an ingredient map, lookup the source ingredient and combine it with the added-key"
  [ingredient-bill ingredient-source added-key]
  (reduce-kv (fn [m k v] (assoc m k (assoc (get ingredient-source k) added-key v))) {} ingredient-bill))

(defn update-or-assoc
  "If `k` exists in `m` apply the `update-fn`.
   Else, assoc `v` to that `k` in `m`"
  [m k v update-fn]
  (if (get m k)
    (update m k update-fn)
    (assoc m k v)))

(defn scale-ingredients
  "Update `ingredient-map` so the combined :weights are randomly scaled up to `weight-limit`"
  [ingredient-map weight-limit]
  (loop [i-map ingredient-map
         weight (reduce + 0 (vals ingredient-map))]
    (if (< weight weight-limit)
      (let [addition (rand-nth ingredients/ingredient-amounts)
            mod-ingredient (rand-nth (keys i-map))]
        (recur (update i-map mod-ingredient + addition)
               (+ weight addition)))
      i-map)))

(defn potential-gravity-to-gravity-points
  [potential-og weight]
  (-> potential-og
      (* 1000)
      (- 1000)
      (* weight)))

(defn gravity-points-to-potential-gravity
  [og-points gallons]
  (-> og-points
      (/ gallons)
      (+ 1000)
      (/ 1000.0)))

(defn calculate-gravity
  ([gallons grains extracts]
   (calculate-gravity gallons grains extracts 0.7)) ;; We assume a mashing efficiency of 70% on average https://beerandbrewing.com/ask-the-experts-mash-efficiency/

  ([gallons grains extracts efficiency]
   (let [grains-gravity    (* efficiency (reduce + 0.0 (map #(potential-gravity-to-gravity-points (:gravity (second %)) (:weight (second %))) grains)))
         extracts-gravity  (reduce + 0.0 (map #(potential-gravity-to-gravity-points (:gravity (second %)) (:weight (second %))) extracts))]
     (gravity-points-to-potential-gravity (+ grains-gravity extracts-gravity) gallons))))
