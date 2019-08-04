(ns brew-bot.core
  "Main fns to build beer recipes"
  (:require [brew-bot.generators :as generators])
  (:gen-class))

(defn generate-beer-recipe
  [strategy grain-limits extract-limits hop-limits yeast-limits]
  (case strategy
    :random (generators/generate-random-recipe (:weight grain-limits) (:weight extract-limits) (:weight hop-limits))
    :limited-random (generators/generate-limited-random-recipe (:weight grain-limits) (:count grain-limits) (:weight extract-limits) (:count extract-limits) (:weight hop-limits) (:count hop-limits))
    {:invalid-strategy "Please pick a legal recipe generation strategy"}))

(defn -main
  "Try me out!"
  [& args]
  (println (generate-beer-recipe :limited-random {:weight 10.0 :count 2} {:weight 5.0 :count 1} {:weight 1.5 :count 2} nil)))
