(ns brew-bot.style-lists.bock
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const helles-bock
  {:bjcp-category          :pale-malty-european-lager
   :name                   "Helles Bock"
   :original-gravity-range [1.064 1.072]
   :ibu-range              [23 35]
   :srm-range              [6 11]
   :abv-range              [6.3 7.4]})

(def ^:const dunkles-bock
  {:bjcp-category          :amber-malty-european-lager
   :name                   "Dunkles Bock"
   :original-gravity-range [1.064 1.072]
   :ibu-range              [20 27]
   :srm-range              [14 22]
   :abv-range              [6.3 7.2]})

(def ^:const doppelbock
  {:bjcp-category          :strong-european-beer
   :name                   "Doppelbock"
   :original-gravity-range [1.072 1.112]
   :ibu-range              [16 26]
   :srm-range              [6 25]
   :abv-range              [7 10]})

(def ^:const eisbock
  {:bjcp-category          :strong-european-beer
   :name                   "Eisbock"
   :original-gravity-range [1.078 1.12]
   :ibu-range              [25 35]
   :srm-range              [18 30]
   :abv-range              [9 14]})

(def ^:const bock
  {:helles-bock  helles-bock
   :dunkles-bock dunkles-bock
   :doppelbock   doppelbock
   :eisbock      eisbock})
