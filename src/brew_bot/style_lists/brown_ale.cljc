(ns brew-bot.style-lists.brown-ale
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const dark-mild
  {:bjcp-category          :brown-british-beer
   :name                   "Dark Mild"
   :original-gravity-range [1.03 1.038]
   :ibu-range              [10 25]
   :srm-range              [12 25]
   :abv-range              [3 3.8]})

(def ^:const  british-brown-ale
  {:bjcp-category          :brown-british-beer
   :name                   "British Brown Ale"
   :original-gravity-range [1.04 1.052]
   :ibu-range              [20 30]
   :srm-range              [12 22]
   :abv-range              [4.2 5.4]})

(def ^:const american-brown-ale
  {:bjcp-category          :amber-and-brown-american-beer
   :name                   "American Brown Ale"
   :original-gravity-range [1.045 1.06]
   :ibu-range              [20 30]
   :srm-range              [18 35]
   :abv-range              [4.3 6.2]})

(def ^:const london-brown-ale
  {:bjcp-category          :historical-beer
   :name                   "London Brown Ale"
   :original-gravity-range [1.033 1.038]
   :ibu-range              [15 20]
   :srm-range              [22 35]
   :abv-range              [2.8 3.6]})

(def ^:const brown-ale
  {:dark-mild          dark-mild
   :british-brown-ale  british-brown-ale
   :american-brown-ale american-brown-ale
   :london-brown-ale   london-brown-ale})
