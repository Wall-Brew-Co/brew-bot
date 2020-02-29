(ns brew-bot.style-lists.dark-lager
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const international-dark-lager
  {:bjcp-category          :international-lager
   :name                   "International Dark Lager"
   :original-gravity-range [1.044 1.056]
   :ibu-range              [8 20]
   :srm-range              [14 22]
   :abv-range              [4.2 6]})

(def ^:const czech-dark-lager
  {:bjcp-category          :czech-lager
   :name                   "Czech Dark Lager"
   :original-gravity-range [1.044 1.06]
   :ibu-range              [18 34]
   :srm-range              [14 35]
   :abv-range              [4.4 5.8]})

(def ^:const munich-dunkel
  {:bjcp-category          :dark-european-lager
   :name                   "Munich Dunkel"
   :original-gravity-range [1.048 1.056]
   :ibu-range              [18 28]
   :srm-range              [14 28]
   :abv-range              [4.5 5.6]})

(def ^:const schwarzbier
  {:bjcp-category          :dark-european-lager
   :name                   "Schwarzbier"
   :original-gravity-range [1.046 1.052]
   :ibu-range              [20 30]
   :srm-range              [17 30]
   :abv-range              [4.4 5.4]})

(def ^:const dark-lager
  {:international-dark-lager international-dark-lager
   :czech-dark-lager         czech-dark-lager
   :munich-dunkel            munich-dunkel
   :schwarzbier              schwarzbier})
