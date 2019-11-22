(ns brew-bot.db
  (:require [brew-bot.ingredients :as ingredients]))

(def ^:const empty-recipe
  {:grains {:weight 5.0 :count 5}
   :extracts {:weight 5.0 :count 1}
   :hops {:weight 3.0 :count 3}
   :yeasts {}
   :gallons 5.0
   :has-recipe-changed? false})

(def ^:const default-db
  {:current-page :home
   :recipe-sources {:grains ingredients/grains
                    :extracts ingredients/extracts
                    :hops ingredients/hops
                    :yeasts ingredients/yeasts}
   :current-recipe empty-recipe})
