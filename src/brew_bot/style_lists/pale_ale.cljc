(ns brew-bot.style-lists.pale-ale
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const cream-ale
  {:bjcp-category          :standard-american-beer
   :name                   "Cream Ale"
   :original-gravity-range [1.042 1.055]
   :ibu-range              [8 20]
   :srm-range              [2.5 5]
   :abv-range              [4.2 5.6]})

(def ^:const kolsch
  {:bjcp-category          :pale-bitter-european-beer
   :name                   "Kölsch"
   :original-gravity-range [1.044 1.05]
   :ibu-range              [18 30]
   :srm-range              [3.5 5]
   :abv-range              [4.4 5.2]})

(def ^:const british-golden-ale
  {:bjcp-category          :pale-commonwealth-beer
   :name                   "British Golden Ale"
   :original-gravity-range [1.038 1.053]
   :ibu-range              [20 45]
   :srm-range              [2 6]
   :abv-range              [3.8 5]})

(def ^:const australian-sparkling-ale
  {:bjcp-category          :pale-commonwealth-beer
   :name                   "Australian Sparkling Ale"
   :original-gravity-range [1.038 1.05]
   :ibu-range              [20 35]
   :srm-range              [4 7]
   :abv-range              [4.5 6]})

(def ^:const blonde-ale
  {:bjcp-category          :pale-american-ale
   :name                   "Blonde Ale"
   :original-gravity-range [1.038 1.054]
   :ibu-range              [15 28]
   :srm-range              [3 6]
   :abv-range              [3.8 5.5]})

(def ^:const american-pale-ale
  {:bjcp-category          :pale-american-ale
   :name                   "American Pale Ale"
   :original-gravity-range [1.045 1.06]
   :ibu-range              [30 50]
   :srm-range              [5 10]
   :abv-range              [4.5 6.2]})

(def ^:const belgian-pale-ale
  {:bjcp-category          :belgian-ale
   :name                   "Belgian Pale Ale"
   :original-gravity-range [1.048 1.054]
   :ibu-range              [20 30]
   :srm-range              [8 14]
   :abv-range              [4.8 5.5]})

(def ^:const belgian-blond-ale
  {:bjcp-category          :strong-belgian-ale
   :name                   "Belgian Blond Ale"
   :original-gravity-range [1.062 1.075]
   :ibu-range              [15 30]
   :srm-range              [4 7]
   :abv-range              [6 7.5]})

(def ^:const saison
  {:bjcp-category          :strong-belgian-ale
   :name                   "Saison"
   :original-gravity-range [1.048 1.065]
   :ibu-range              [20 35]
   :srm-range              [5 22]
   :abv-range              [3.5 9.5]})

(def ^:const trappist-single
  {:bjcp-category          :trappist-ale
   :name                   "Trappist Single"
   :original-gravity-range [1.044 1.054]
   :ibu-range              [25 45]
   :srm-range              [3 5]
   :abv-range              [4.8 6]})

(def ^:const pale-ale
  {:cream-ale                cream-ale
   :kolsch                   kolsch
   :british-golden-ale       british-golden-ale
   :australian-sparkling-ale australian-sparkling-ale
   :blonde-ale               blonde-ale
   :american-pale-ale        american-pale-ale
   :belgian-pale-ale         belgian-pale-ale
   :belgian-blond-ale        belgian-blond-ale
   :saison                   saison
   :trappist-single          trappist-single})
