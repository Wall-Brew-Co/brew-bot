(ns brew-bot.style-lists.stout
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const irish-stout
  {:bjcp-category          :irish-beer
   :name                   "Irish Stout"
   :original-gravity-range [1.036 1.044]
   :ibu-range              [25 45]
   :srm-range              [25 40]
   :abv-range              [4 4.5]})

(def ^:const irish-extra-stout
  {:bjcp-category          :irish-beer
   :name                   "Irish Extra Stout"
   :original-gravity-range [1.052 1.062]
   :ibu-range              [35 50]
   :srm-range              [25 40]
   :abv-range              [5.5 6.5]})

(def ^:const sweet-stout
  {:bjcp-category          :dark-british-beer
   :name                   "Sweet Stout"
   :original-gravity-range [1.044 1.06]
   :ibu-range              [20 40]
   :srm-range              [30 40]
   :abv-range              [4 6]})

(def ^:const oatmeal-stout
  {:bjcp-category          :dark-british-beer
   :name                   "Oatmeal Stout"
   :original-gravity-range [1.045 1.065]
   :ibu-range              [25 40]
   :srm-range              [22 40]
   :abv-range              [4.2 5.9]})

(def ^:const tropical-stout
  {:bjcp-category          :dark-british-beer
   :name                   "Tropical Stout"
   :original-gravity-range [1.056 1.075]
   :ibu-range              [30 50]
   :srm-range              [30 40]
   :abv-range              [5.5 8]})

(def ^:const foreign-extra-stout
  {:bjcp-category          :dark-british-beer
   :name                   "Foreign Extra Stout"
   :original-gravity-range [1.056 1.075]
   :ibu-range              [50 70]
   :srm-range              [30 40]
   :abv-range              [6.3 8]})

(def ^:const american-stout
  {:bjcp-category          :american-porter-and-stout
   :name                   "American Stout"
   :original-gravity-range [1.05 1.075]
   :ibu-range              [35 75]
   :srm-range              [30 40]
   :abv-range              [5 7]})

(def ^:const imperial-stout
  {:bjcp-category          :american-porter-and-stout
   :name                   "Imperial Stout"
   :original-gravity-range [1.075 1.115]
   :ibu-range              [50 90]
   :srm-range              [30 40]
   :abv-range              [8 12]})

(def ^:const stout
  {:irish-stout         irish-stout
   :irish-extra-stout   irish-extra-stout
   :sweet-stout         sweet-stout
   :oatmeal-stout       oatmeal-stout
   :tropical-stout      tropical-stout
   :foreign-extra-stout foreign-extra-stout
   :american-stout      american-stout
   :imperial-stout      imperial-stout})
