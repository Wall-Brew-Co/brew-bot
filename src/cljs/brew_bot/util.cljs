(ns brew-bot.util
  "Common fns required across brew-bot"
  (:require [cljx-sampling.core :as rnd]
            [brew-bot.recipe-generation.ingredients :as ingredients]))

(defn rand-key
  "Pick a random key from a map, weighted by the :probability key of the value"
  [m]
  (first (rnd/sample (keys m) :replace true :weigh #(or (:probability (get m %)) 1))))

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
  "Calculate the OG by calculating the combined gravity points of each ingredient, and converting that to a normalized gravity: e.g. 1.040"
  ([gallons grains extracts]
   (calculate-gravity gallons grains extracts 0.7)) ;; We assume a mashing efficiency of 70% on average https://beerandbrewing.com/ask-the-experts-mash-efficiency/

  ([gallons grains extracts efficiency]
   (let [reducing-fn      (fn [acc k v] (+ acc (potential-gravity-to-gravity-points (:gravity v) (:weight v))))
         grains-gravity   (* efficiency (reduce-kv reducing-fn 0.0 grains))
         extracts-gravity (reduce-kv reducing-fn 0.0 extracts)]
     (gravity-points-to-potential-gravity (+ grains-gravity extracts-gravity) gallons))))

(defn calculate-estimated-abv
  "A rough estimate of ABV from OG as delineated here: https://homebrew.stackexchange.com/questions/12569/calculating-potential-abv"
  [original-gravity]
  (-> original-gravity
      (* 1000)
      (- 1000)
      (* 0.75 0.135)))

(defn calculate-hop-bittering-units
  "Calculate the number of IBUs a particular hop contributes to a beer based on: https://www.realbeer.com/hops/bcalc_js.html"
  [gallons gravity hop]
  (let [alpha (:alpha hop)
        weight (:weight hop)
        time-boiled (:time-boiled hop)
        alpha-density (/ (* alpha weight 7490) gallons)
        utilization-percent (* 1.65 (Math/pow 0.000125 gravity) (- 1 (Math/exp (* -0.04 time-boiled))))]
    (* alpha-density utilization-percent)))

(defn calculate-recipe-bittering-units
  [gallons gravity hops]
  (let [reducing-fn (fn [acc k v] (+ acc (calculate-hop-bittering-units gallons gravity v)))]
    (reduce-kv reducing-fn 0 hops)))
