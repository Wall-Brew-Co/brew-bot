(ns brew-bot.main
  (:require [brew-bot.generators :as generators]
            [brew-bot.ingredients :as ingredients]
            [brew-bot.weights :as weights]
            [nnichols.util :as nu])
  (:gen-class))

(defn -main
  [& args]
  (println "I don't do very much, yet..."))

(nu/rand-kv ingredients/grains)
(nu/rand-kv ingredients/extracts)
(nu/rand-kv ingredients/hops)
(nu/rand-kv ingredients/yeasts)

(generators/generate-beer-recipe :random 5 {:weight 5} {:weight 3.5} {:weight 1.5} {})
