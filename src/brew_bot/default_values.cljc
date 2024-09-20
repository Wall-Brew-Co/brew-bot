(ns brew-bot.default-values
  "Default values for beer recipe generators")


(def common-beer-format-version 1)

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
  {"boil"        200.0
   "dry hop"     20.0
   "mash"        40.0
   "first wort"  40.0
   "aroma"       10.0})


(def aroma-hop-use-weights
  {"boil"        200.0
   "dry hop"     80.0
   "mash"        10.0
   "first wort"  10.0
   "aroma"       40.0})


(def both-hop-use-weights
  {"boil"        200.0
   "dry hop"     80.0
   "mash"        10.0
   "first wort"  10.0
   "aroma"       10.0})


(def common-beer-format-default-mash
  {:name       "Single Step Infusion"
   :version    common-beer-format-version
   :grain-temp 22.0
   :mash-steps [{:mash-step {:name          "Sugar Conversion Step"
                             :version       common-beer-format-version
                             :type          "Infusion"
                             :step-temp     68.0
                             :step-time     60.0
                             :infuse-amount 10.0}}]})


(def common-beer-format-recipe-defaults
  {:name         "My Recipe"
   :version      common-beer-format-version
   :brewer       "brew-bot"
   :batch-size   19 ; Roughly 5 gallons, common homebrew size
   :boil-size    19 ; Roughly 5 gallons, common homebrew size
   :miscs        []
   :waters       []
   :mash         common-beer-format-default-mash})
