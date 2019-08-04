(ns brew-bot.util
  "Common fns required across recipe generation strategies"
  (:require [brew-bot.ingredients :as ingredients]))

(defn rand-key
  "Pick a random key from a map"
  [m]
  (rand-nth (keys m)))

(defn join-ingredient-maps
  "Given an ingredient map, lookup the source ingredient and combine it with the weight"
  [ingredient-bill ingredient-source]
  (reduce-kv (fn [m k v] (assoc m k (assoc (get ingredient-source k) :weight v))) {} ingredient-bill))

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
