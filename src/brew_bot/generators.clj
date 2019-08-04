(ns brew-bot.generators
  "Beer recipe generators"
  (:require [brew-bot.ingredients :as ingredients]
            [brew-bot.util :as util]))

(defn format-recipe
  [grain-bill extract-bill hop-bill yeast]
  {:grains   grain-bill
   :extracts extract-bill
   :hops     hop-bill
   :yeast    yeast})

(defn generate-ingredients-and-quantities
  ([ingredient-set weight-cutoff]
   (generate-ingredients-and-quantities ingredient-set weight-cutoff :unlimited))

  ([ingredient-set weight-cutoff ingredient-limit]
   (loop [ingredient-map {}
          weight 0.0
          ingredient-count 0]
     (if (or (= ingredient-limit :unlimited)
             (< ingredient-count ingredient-limit))
       (if (< weight weight-cutoff)
         (let [selected-ingredient (util/rand-key ingredient-set)
               ingredient-addition (rand-nth ingredients/ingredient-amounts)
               updated-map (util/update-or-assoc ingredient-map selected-ingredient ingredient-addition #(+ ingredient-addition %))]
           (recur updated-map
                  (+ weight ingredient-addition)
                  (count (keys updated-map))))
         ingredient-map)
       (util/scale-ingredients ingredient-map weight-cutoff)))))

(defn generate-random-recipe
  "Generate a purely random beer recipe with grains, extracts, and hops close to their respective limits"
  [grain-weight-limit extract-weight-limit hop-weight-limit]
  (let [grain-bill   (generate-ingredients-and-quantities ingredients/base-grains grain-weight-limit)
        extract-bill (generate-ingredients-and-quantities ingredients/extracts    extract-weight-limit)
        hop-bill     (generate-ingredients-and-quantities ingredients/hops        hop-weight-limit)
        yeast        (util/rand-key ingredients/yeasts)]
    (format-recipe grain-bill extract-bill hop-bill yeast)))

(defn generate-limited-random-recipe
  "Generate a purely random beer recipe with grains, extracts,
   and hops close to their respective weight limits, with a constricted number of ingredients"
  [grain-weight-limit grain-item-limit extract-weight-limit extract-item-limit hop-weight-limit hop-item-limit]
  (let [grain-bill   (generate-ingredients-and-quantities ingredients/base-grains grain-weight-limit   grain-item-limit)
        extract-bill (generate-ingredients-and-quantities ingredients/extracts    extract-weight-limit extract-item-limit)
        hop-bill     (generate-ingredients-and-quantities ingredients/hops        hop-weight-limit     hop-item-limit)
        yeast        (util/rand-key ingredients/yeasts)]
    (format-recipe grain-bill extract-bill hop-bill yeast)))
