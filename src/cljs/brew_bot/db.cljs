(ns brew-bot.db
  (:require [brew-bot.recipe-generation.ingredients :as ingredients]))

(def default-db
  {:current-page :home
   :recipe-sources {:grains   ingredients/grains
                    :extracts ingredients/extracts
                    :hops     ingredients/hops
                    :yeasts   ingredients/yeasts}})
