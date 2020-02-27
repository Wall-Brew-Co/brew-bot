(ns brew-bot.style-lists.ipa
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const english-ipa
  {:bjcp-category          :pale-commonwealth-beer
   :name                   "English IPA"
   :original-gravity-range [1.05 1.075]
   :ibu-range              [40 60]
   :srm-range              [6 14]
   :abv-range              [5 7.5]})

(def ^:const american-ipa
  {:bjcp-category          :ipa
   :name                   "American IPA"
   :original-gravity-range [1.056 1.07]
   :ibu-range              [40 70]
   :srm-range              [6 14]
   :abv-range              [5.5 7.5]})

(def ^:const belgian-ipa
  {:bjcp-category          :ipa
   :name                   "Belgian IPA"
   :original-gravity-range [1.058 1.08]
   :ibu-range              [50 100]
   :srm-range              [5 15]
   :abv-range              [6.2 9.5]})

(def ^:const black-ipa
  {:bjcp-category          :ipa
   :name                   "Black IPA"
   :original-gravity-range [1.05 1.085]
   :ibu-range              [50 90]
   :srm-range              [25 40]
   :abv-range              [5.5 9]})

(def ^:const brown-ipa
  {:bjcp-category          :ipa
   :name                   "Brown IPA"
   :original-gravity-range [1.056 1.07]
   :ibu-range              [40 70]
   :srm-range              [11 19]
   :abv-range              [5.5 7.5]})

(def ^:const red-ipa
  {:bjcp-category          :ipa
   :name                   "Red IPA"
   :original-gravity-range [1.056 1.07]
   :ibu-range              [40 70]
   :srm-range              [11 19]
   :abv-range              [5.5 7.5]})

(def ^:const rye-ipa
  {:bjcp-category          :ipa
   :name                   "Rye IPA"
   :original-gravity-range [1.056 1.075]
   :ibu-range              [50 75]
   :srm-range              [6 14]
   :abv-range              [5.5 8]})

(def ^:const white-ipa
  {:bjcp-category          :ipa
   :name                   "White IPA"
   :original-gravity-range [1.056 1.065]
   :ibu-range              [40 70]
   :srm-range              [5 8]
   :abv-range              [5.5 7]})

(def ^:const double-ipa
  {:bjcp-category          :strong-american-ale
   :name                   "Double IPA"
   :original-gravity-range [1.065 1.085]
   :ibu-range              [60 120]
   :srm-range              [6 14]
   :abv-range              [7.5 10]})

(def ^:const ipa
  {:english-ipa  english-ipa
   :american-ipa american-ipa
   :belgian-ipa  belgian-ipa
   :black-ipa    black-ipa
   :brown-ipa    brown-ipa
   :red-ipa      red-ipa
   :rye-ipa      rye-ipa
   :white-ipa    white-ipa
   :double-ipa   double-ipa})
