(ns brew-bot.style-lists.pale-lager
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const american-light-lager
  {:bjcp-category          :standard-american-beer
   :name                   "American Light Lager"
   :original-gravity-range [1.028 1.04]
   :ibu-range              [8 12]
   :srm-range              [2 3]
   :abv-range              [2.8 4.2]})

(def ^:const american-lager
  {:bjcp-category          :standard-american-beer
   :name                   "American Lager"
   :original-gravity-range [1.04 1.05]
   :ibu-range              [8 18]
   :srm-range              [2 4]
   :abv-range              [4.2 5.3]})

(def ^:const international-pale-lager
  {:bjcp-category          :international-lager
   :name                   "International Pale Lager"
   :original-gravity-range [1.042 1.05]
   :ibu-range              [18 25]
   :srm-range              [2 6]
   :abv-range              [4.6 6]})

(def ^:const czech-pale-lager
  {:bjcp-category          :czech-lager
   :name                   "Czech Pale Lager"
   :original-gravity-range [1.028 1.044]
   :ibu-range              [20 35]
   :srm-range              [3 6]
   :abv-range              [3 4.1]})

(def ^:const munich-helles
  {:bjcp-category          :pale-malty-european-lager
   :name                   "Munich Helles"
   :original-gravity-range [1.044 1.048]
   :ibu-range              [16 22]
   :srm-range              [3 5]
   :abv-range              [4.7 5.4]})

(def ^:const festbier
  {:bjcp-category          :pale-malty-european-lager
   :name                   "Festbier"
   :original-gravity-range [1.054 1.057]
   :ibu-range              [18 25]
   :srm-range              [4 7]
   :abv-range              [5.8 6.3]})

(def ^:const german-leichtbier
  {:bjcp-category          :pale-bitter-european-beer
   :name                   "German Leichtbier"
   :original-gravity-range [1.026 1.034]
   :ibu-range              [15 28]
   :srm-range              [2 5]
   :abv-range              [2.4 3.6]})

(def ^:const german-helles-exportbier
  {:bjcp-category          :pale-bitter-european-beer
   :name                   "German Helles Exportbier"
   :original-gravity-range [1.048 1.056]
   :ibu-range              [20 30]
   :srm-range              [4 7]
   :abv-range              [4.8 6]})

(def ^:const pale-kellerbier
  {:bjcp-category          :amber-bitter-european-beer
   :name                   "Pale Kellerbier"
   :original-gravity-range [1.045 1.051]
   :ibu-range              [20 35]
   :srm-range              [3 7]
   :abv-range              [4.7 5.4]})

(def ^:const pale-lager
  {:american-light-lager     american-light-lager
   :american-lager           american-lager
   :international-pale-lager international-pale-lager
   :czech-pale-lager         czech-pale-lager
   :munich-helles            munich-helles
   :festbier                 festbier
   :german-leichtbier        german-leichtbier
   :german-helles-exportbier german-helles-exportbier
   :pale-kellerbier          pale-kellerbier})
