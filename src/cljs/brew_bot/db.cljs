(ns brew-bot.db
  (:require [brew-bot.recipe-generation.ingredients :as ingredients]))

(def default-db
  {:current-page :home
   :recipe-sources {:grains   ingredients/grains
                    :extracts ingredients/extracts
                    :hops     ingredients/hops
                    :yeasts   ingredients/yeasts}
   :current-recipe {:grain-opts   {}
                    :extract-opts {}
                    :hop-opts     {}
                    :yeast-opts   {}
                    :gallons      0
                    :has-started? false}})
