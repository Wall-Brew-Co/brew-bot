(ns brew-bot.style-lists.light-lager
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const lite-american-lager
  {:original-gravity-range [1.030 1.040]
   :ibu-range              [8 12]
   :srm-range              [2 3]
   :abv-range              [3.2 4.2]})

(def ^:const standard-american-lager
  {:original-gravity-range [1.040 1.050]
   :ibu-range              [8 15]
   :srm-range              [2 4]
   :abv-range              [4.2 5.1]})

(def ^:const premium-american-lager
  {:original-gravity-range [1.046 1.056]
   :ibu-range              [15 25]
   :srm-range              [2 6]
   :abv-range              [4.7 6.0]})

(def ^:const munich-helles
  {:original-gravity-range [1.045 1.051]
   :ibu-range              [16 22]
   :srm-range              [3 5]
   :abv-range              [4.7 5.4]})

(def ^:const dortmunder-export
  {:original-gravity-range [1.048 1.056]
   :ibu-range              [23 30]
   :srm-range              [4 6]
   :abv-range              [4.8 6.0]})

(def ^:const light-lager
  {:lite-american-lager     lite-american-lager
   :standard-american-lager standard-american-lager
   :premium-american-lager  premium-american-lager
   :munich-helles           munich-helles
   :dortmunder-export       dortmunder-export})
