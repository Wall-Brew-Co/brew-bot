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

;(defn -main
;  "Try me out!"
;  [& args]
;  (println (generate-beer-recipe :weighted-random
;                                 5
;                                 {:weight 5.0 :probabilities {:pale-malt-2-row-us 40 :pale-malt-2-row-uk 40 :caramel-crystal-malt-40l 20 :caramel-crystal-malt-60l 10 :chocolate-malt 2 :black-patent-malt 1}}
;                                 {:weight 3.5 :probabilities {:amber-liquid-extract 1 :light-dry-extract 1}}
;                                 {:weight 3.0 :probabilities {:magnum-us 2 :willamette 4 :liberty 1 :cascade 1}}
;                                 {:probabilities {:wyeast-labs-european-ale 1 :wyeast-labs-irish-ale 1 :wyeast-labs-american-ale 1 :wyeast-labs-belgian-saison 1}})))
