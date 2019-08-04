(ns brew-bot.generators
  "Beer recipe generators"
  (:require [brew-bot.ingredients :as ingredients]
            [brew-bot.util :as util]))

(defn format-recipe
  "Given maps of ingredient : weight pairs, format a recipe and derive other important information"
  [gallons grain-bill extract-bill hop-bill yeast]
  (let [grains   (util/join-ingredient-maps grain-bill   ingredients/base-grains)
        extracts (util/join-ingredient-maps extract-bill ingredients/extracts)
        hops     (util/join-ingredient-maps hop-bill     ingredients/hops)]
    {:grains   grains
     :extracts extracts
     :hops     hops
     :yeast    yeast
     :original-gravity (util/calculate-gravity gallons grains extracts)}))

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
  [gallons grain-weight-limit extract-weight-limit hop-weight-limit]
  (let [grain-bill   (generate-ingredients-and-quantities ingredients/base-grains grain-weight-limit)
        extract-bill (generate-ingredients-and-quantities ingredients/extracts    extract-weight-limit)
        hop-bill     (generate-ingredients-and-quantities ingredients/hops        hop-weight-limit)
        yeast        (util/rand-key ingredients/yeasts)]
    (format-recipe gallons grain-bill extract-bill hop-bill yeast)))

(defn generate-limited-random-recipe
  "Generate a purely random beer recipe with grains, extracts,
   and hops close to their respective weight limits, with a constricted number of ingredients"
  [gallons grain-weight-limit grain-item-limit extract-weight-limit extract-item-limit hop-weight-limit hop-item-limit]
  (let [grain-bill   (generate-ingredients-and-quantities ingredients/base-grains grain-weight-limit   grain-item-limit)
        extract-bill (generate-ingredients-and-quantities ingredients/extracts    extract-weight-limit extract-item-limit)
        hop-bill     (generate-ingredients-and-quantities ingredients/hops        hop-weight-limit     hop-item-limit)
        yeast        (util/rand-key ingredients/yeasts)]
    (format-recipe gallons grain-bill extract-bill hop-bill yeast)))
