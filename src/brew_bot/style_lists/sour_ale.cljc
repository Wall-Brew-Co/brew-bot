(ns brew-bot.style-lists.sour-ale
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const flanders-red-ale
  {:bjcp-category          :european-sour-ale
   :name                   "Flanders Red Ale"
   :original-gravity-range [1.048 1.057]
   :ibu-range              [10 25]
   :srm-range              [10 16]
   :abv-range              [4.6 6.5]})

(def ^:const oud-bruin
  {:bjcp-category          :european-sour-ale
   :name                   "Oud Bruin"
   :original-gravity-range [1.04 1.074]
   :ibu-range              [20 25]
   :srm-range              [15 22]
   :abv-range              [4 8]})

(def ^:const sour-ale
  {:flanders-red-ale flanders-red-ale
   :oud-bruin        oud-bruin})
