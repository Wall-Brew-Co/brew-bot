(ns brew-bot.style-lists.pilsner
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const czech-premium-pale-lager
  {:bjcp-category          :czech-lager
   :name                   "Czech Premium Pale Lager"
   :original-gravity-range [1.044 1.060]
   :ibu-range              [30 45]
   :srm-range              [3.5 6]
   :abv-range              [4.2 5.8]})

(def ^:const german-pils
  {:bjcp-category          :pale-bitter-european-beer
   :name                   "Pale Bitter European Beer"
   :original-gravity-range [1.044 1.050]
   :ibu-range              [22 40]
   :srm-range              [2 5]
   :abv-range              [4.4 5.2]})

(def ^:const pre-prohibition-lager
  {:bjcp-category          :historical-beer
   :name                   "Pre-Prohibition Lager"
   :original-gravity-range [1.044 1.060]
   :ibu-range              [25 40]
   :srm-range              [3 6]
   :abv-range              [4.5 6.0]})

(def ^:const pilsner
  {:czech-premium-pale-lager czech-premium-pale-lager
   :german-pils              german-pils
   :pre-prohibition-lager    pre-prohibition-lager})
