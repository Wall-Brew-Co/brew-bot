(ns brew-bot.core
  "Main fns to build beer recipes"
  (:require [brew-bot.recipe-generation.generators :as generators]))

(defn generate-beer-recipe
  [strategy gallons grain-limits extract-limits hop-limits yeast-limits]
  (case strategy
    :random (generators/generate-random-recipe gallons grain-limits extract-limits hop-limits)
    :limited-random (generators/generate-limited-random-recipe gallons grain-limits extract-limits hop-limits)
    :weighted-guided (generators/generate-weighted-guided-recipe gallons grain-limits extract-limits hop-limits yeast-limits)
    :weighted-random (generators/generate-weighted-random-recipe gallons grain-limits extract-limits hop-limits yeast-limits)
    {:invalid-strategy "Please pick a legal recipe generation strategy"}))
