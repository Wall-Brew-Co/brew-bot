(ns brew-bot.recipe-generation.generators
  "Beer recipe generators"
  (:require [brew-bot.recipe-generation.ingredients :as ingredients]
            [brew-bot.util :as util]))

(defn format-recipe
  "Given maps of ingredient : weight pairs, format a recipe and derive other important information"
  [gallons grain-bill extract-bill hop-bill yeast]
  (let [grains   (util/join-ingredient-maps grain-bill ingredients/grains :weight)
        extracts (util/join-ingredient-maps extract-bill ingredients/extracts :weight)
        hops     (util/join-ingredient-maps hop-bill ingredients/hops :weight)]
    {:grains   grains
     :extracts extracts
     :hops     hops
     :yeasts   {yeast (get ingredients/yeasts yeast)}
     :gravity  (util/calculate-gravity gallons grains extracts)}))

(defn update-selection-probability
  [probabilities ingredient-map include-all?]
  (let [weighted-ingredients (util/join-ingredient-maps probabilities ingredient-map :probability)]
    (if include-all?
      (merge ingredient-map weighted-ingredients)
      weighted-ingredients)))

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
  [gallons grain-limits extract-limits hop-limits]
  (let [grain-bill   (generate-ingredients-and-quantities ingredients/grains   (:weight grain-limits))
        extract-bill (generate-ingredients-and-quantities ingredients/extracts (:weight extract-limits))
        hop-bill     (generate-ingredients-and-quantities ingredients/hops     (:weight hop-limits))
        yeast        (util/rand-key ingredients/yeasts)]
    (format-recipe gallons grain-bill extract-bill hop-bill yeast)))

(defn generate-limited-random-recipe
  "Generate a purely random beer recipe with grains, extracts,
   and hops close to their respective weight limits, with a constricted number of ingredients"
  [gallons grain-limits extract-limits hop-limits]
  (let [grain-bill   (generate-ingredients-and-quantities ingredients/grains   (:weight grain-limits)   (:count grain-limits))
        extract-bill (generate-ingredients-and-quantities ingredients/extracts (:weight extract-limits) (:count extract-limits))
        hop-bill     (generate-ingredients-and-quantities ingredients/hops     (:weight hop-limits)     (:count hop-limits))
        yeast        (util/rand-key ingredients/yeasts)]
    (format-recipe gallons grain-bill extract-bill hop-bill yeast)))

(defn generate-weighted-guided-recipe
  [gallons grain-limits extract-limits hop-limits yeast-limits]
  (let [grain-selections   (update-selection-probability (:probabilities grain-limits)   ingredients/grains false)
        extract-selections (update-selection-probability (:probabilities extract-limits) ingredients/extracts false)
        hop-selections     (update-selection-probability (:probabilities hop-limits)     ingredients/hops false)
        yeast-selections   (update-selection-probability (:probabilities yeast-limits)   ingredients/yeasts false)
        grain-bill   (generate-ingredients-and-quantities grain-selections   (:weight grain-limits))
        extract-bill (generate-ingredients-and-quantities extract-selections (:weight extract-limits))
        hop-bill     (generate-ingredients-and-quantities hop-selections     (:weight hop-limits))
        yeast        (util/rand-key yeast-selections)]
    (format-recipe gallons grain-bill extract-bill hop-bill yeast)))

(defn generate-weighted-random-recipe
  [gallons grain-limits extract-limits hop-limits yeast-limits]
  (let [grain-selections   (update-selection-probability (:probabilities grain-limits)   ingredients/grains true)
        extract-selections (update-selection-probability (:probabilities extract-limits) ingredients/extracts true)
        hop-selections     (update-selection-probability (:probabilities hop-limits)     ingredients/hops true)
        yeast-selections   (update-selection-probability (:probabilities yeast-limits)   ingredients/yeasts true)
        grain-bill   (generate-ingredients-and-quantities grain-selections   (:weight grain-limits))
        extract-bill (generate-ingredients-and-quantities extract-selections (:weight extract-limits))
        hop-bill     (generate-ingredients-and-quantities hop-selections     (:weight hop-limits))
        yeast        (util/rand-key yeast-selections)]
    (format-recipe gallons grain-bill extract-bill hop-bill yeast)))
