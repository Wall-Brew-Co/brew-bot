(ns brew-bot.db
  (:require [brew-bot.recipe-generation.ingredients :as ingredients]))

(def default-db
  {:current-page :home
   :recipe-sources {:grains   ingredients/grains
                    :extracts ingredients/extracts
                    :hops     ingredients/hops
                    :yeasts   ingredients/yeasts}
   :current-recipe {:grain-opts   {:weight 5.0 :count 5}
                    :extract-opts {:weight 5.0 :count 1}
                    :hop-opts     {:weight 3.0 :count 3}
                    :yeast-opts   {}
                    :gallons      5.0
                    :has-started? false}})
