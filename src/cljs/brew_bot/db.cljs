(ns brew-bot.db
  (:require [brew-bot.recipe-generation.ingredients :as ingredients]))

(def default-db
  {:current-page :home
   :recipe-sources {:grains ingredients/grains
                    :extracts ingredients/extracts
                    :hops ingredients/hops
                    :yeasts ingredients/yeasts}
   :current-recipe {:grains {:weight 5.0 :count 5}
                    :extracts {:weight 5.0 :count 1}
                    :hops {:weight 3.0 :count 3}
                    :yeasts {}
                    :gallons 5.0
                    :has-started? false}})
