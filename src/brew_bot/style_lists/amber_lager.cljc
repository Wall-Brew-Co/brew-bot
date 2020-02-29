(ns brew-bot.style-lists.amber-lager
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const international-amber-lager
  {:bjcp-category          :international-lager
   :name                   "International Amber Lager"
   :original-gravity-range [1.042 1.055]
   :ibu-range              [8 25]
   :srm-range              [7 14]
   :abv-range              [4.6 6]})

(def ^:const czech-amber-lager
  {:bjcp-category          :czech-lager
   :name                   "Czech Amber Lager"
   :original-gravity-range [1.044 1.06]
   :ibu-range              [20 35]
   :srm-range              [10 16]
   :abv-range              [4.4 5.8]})

(def ^:const marzen
  {:bjcp-category          :amber-malty-european-lager
   :name                   "Märzen"
   :original-gravity-range [1.054 1.06]
   :ibu-range              [18 24]
   :srm-range              [8 17]
   :abv-range              [5.8 6.3]})

(def ^:const rauchbier
  {:bjcp-category          :amber-malty-european-lager
   :name                   "Rauchbier"
   :original-gravity-range [1.05 1.057]
   :ibu-range              [20 30]
   :srm-range              [12 22]
   :abv-range              [4.8 6]})

(def ^:const vienna-lager
  {:bjcp-category          :amber-bitter-european-beer
   :name                   "Vienna Lager"
   :original-gravity-range [1.048 1.055]
   :ibu-range              [18 30]
   :srm-range              [9 15]
   :abv-range              [4.7 5.5]})

(def ^:const amber-kellerbier
  {:bjcp-category          :amber-bitter-european-beer
   :name                   "Amber Kellerbier"
   :original-gravity-range [1.048 1.054]
   :ibu-range              [25 40]
   :srm-range              [7 17]
   :abv-range              [4.8 5.4]})

(def ^:const california-common
  {:bjcp-category          :amber-and-brown-american-beer
   :name                   "California Common"
   :original-gravity-range [1.048 1.054]
   :ibu-range              [30 45]
   :srm-range              [10 14]
   :abv-range              [4.5 5.5]})

(def ^:const amber-lager
  {:international-amber-lager international-amber-lager
   :czech-amber-lager         czech-amber-lager
   :marzen                    marzen
   :rauchbier                 rauchbier
   :vienna-lager              vienna-lager
   :amber-kellerbier          amber-kellerbier
   :california-common         california-common})
