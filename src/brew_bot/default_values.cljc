(ns brew-bot.default-values
  "Default values for beer recipe generators"
  (:require [common-beer-format.hops :as hops]
            [common-beer-format.mash :as mash]
            [common-beer-format.recipes :as recipe]))


(def common-beer-format-version
  "The BeerXML version this library is based on."
  1)


(def amount-cutoff 2.26796) ; 5 pounds in kilograms

(def ingredient-amounts
  [0.01 0.025 0.05 0.075 0.1])


(def minimum-ingredient-amount
  (apply min ingredient-amounts))


(def hop-times
  [120 90 60 45 30 15 10 5 1])


(def bittering-hop-time-weights
  {120 100.0
   90  80.0
   60  60.0
   45  40.0
   30  20.0
   15  0.0
   10  0.0
   5   0.0
   1   0.0})


(def aroma-hop-time-weights
  {1   100.0
   5   80.0
   10  60.0
   15  40.0
   30  20.0
   45  0.0
   60  0.0
   90  0.0
   120 0.0})


(def both-hop-time-weights
  {120 20.0
   90  40.0
   60  60.0
   45  80.0
   30  100.0
   15  80.0
   10  60.0
   5   40.0
   1   20.0})


(def bittering-hop-use-weights
  {hops/boil       200.0
   hops/dry-hop    20.0
   hops/mash       40.0
   hops/first-wort 40.0
   hops/aroma      10.0})


(def aroma-hop-use-weights
  {hops/boil       200.0
   hops/dry-hop    80.0
   hops/mash       10.0
   hops/first-wort 10.0
   hops/aroma      40.0})


(def both-hop-use-weights
  {hops/boil       200.0
   hops/dry-hop    80.0
   hops/mash       10.0
   hops/first-wort 10.0
   hops/aroma      10.0})


(def common-beer-format-default-mash
  {mash/name       "Single Step Infusion"
   mash/version    common-beer-format-version
   mash/grain-temp 22.0
   mash/mash-steps [{mash/mash-step {mash/name          "Sugar Conversion Step"
                                     mash/version       common-beer-format-version
                                     mash/type          mash/infusion
                                     mash/step-temp     68.0
                                     mash/step-time     60.0
                                     mash/infuse-amount 10.0}}]})


(def common-beer-format-recipe-defaults
  {recipe/name       "My Recipe"
   recipe/version    common-beer-format-version
   recipe/brewer     "brew-bot"
   recipe/batch-size 19 ; Roughly 5 gallons, common homebrew size
   recipe/boil-size  19 ; Roughly 5 gallons, common homebrew size
   recipe/miscs      []
   recipe/waters     []
   recipe/mash       common-beer-format-default-mash})
