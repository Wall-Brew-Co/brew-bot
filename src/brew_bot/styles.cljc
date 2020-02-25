(ns brew-bot.styles
  "Convenience functions and refs to access recipe style data"
  (:require [brew-bot.style-lists.light-lager :as bbll]))

(def ^:const global-original-gravity-range
  [1.000 2.000])

(def ^:const global-ibu-range
  [0 150])

(def ^:const global-srm-range
  [0 40])

(def ^:const global-abv-range
  [0.0 100.0])
