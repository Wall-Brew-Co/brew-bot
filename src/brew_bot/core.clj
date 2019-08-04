(ns brew-bot.core
  "Main fns to build beer recipes"
  (:require [brew-bot.ingredients :as ingredients]
            [clojure.set :as cset])
  (:gen-class))

(defn update-or-assoc
  "If `k` exists in `m` apply the `update-fn`.
   Else, assoc `v` to that `k` in `m`"
  [m k v update-fn]
  (if (get m k)
    (update m k update-fn)
    (assoc m k v)))

(defn scale-ingredients
  [ingredient-map weight-limit current-weight]
  (loop [i-map ingredient-map
         weight current-weight]
    (if (< weight weight-limit)
      (let [addition (rand-nth ingredients/ingredient-amounts)
            mod-ingredient (rand-nth (keys i-map))]
        (recur (update i-map mod-ingredient + addition)
               (+ weight addition)))
      i-map)))

(defn generate-ingredients-and-quantities
  [ingredient-set weight-cutoff ingredient-limit]
  (loop [ingredient-map {}
         weight 0.0
         ingredient-count 0]
    (let [selected-ingredient (rand-nth (keys ingredient-set))
          ingredient-addition (rand-nth ingredients/ingredient-amounts)]
      (if (< ingredient-count ingredient-limit)
        (if (< weight weight-cutoff)
          (recur (update-or-assoc ingredient-map selected-ingredient ingredient-addition #(+ ingredient-addition %))
                 (+ weight ingredient-addition)
                 (count (keys ingredient-map)))
          ingredient-map)
        (scale-ingredients ingredient-map weight-cutoff weight)))))

(defn generate-beer-recipe
  [grain-weight-limit grain-item-limit extract-weight-limit extract-item-limit hop-weight-limit hop-item-limit]
  (let [grain-bill   (generate-ingredients-and-quantities ingredients/base-grains grain-weight-limit   grain-item-limit)
        extract-bill (generate-ingredients-and-quantities ingredients/extracts    extract-weight-limit extract-item-limit)
        hop-bill     (generate-ingredients-and-quantities ingredients/hops        hop-weight-limit     hop-item-limit)
        yeast        (rand-nth (keys ingredients/yeasts))
        _ (println grain-bill)
        _ (println extract-bill)
        _ (println (map #(str (first %) " " (second %) "oz " (rand-nth ingredients/hop-times)) hop-bill))
        _ (println yeast)]
    :placeholder))

(defn -main
  "Try me out!"
  [& args]
  (generate-beer-recipe 10.0 3 5.0 1 1.5 2))
