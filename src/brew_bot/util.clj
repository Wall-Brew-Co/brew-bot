(ns brew-bot.util
  "Common fns required across recipe generation strategies"
  (:require [brew-bot.ingredients :as ingredients]))

(defn rand-key
  "Pick a random key from a map"
  [m]
  (rand-nth (keys m)))

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
