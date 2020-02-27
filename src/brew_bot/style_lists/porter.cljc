(ns brew-bot.style-lists.porter
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const baltic-porter
  {:bjcp-category          :strong-european-beer
   :name                   "Baltic Porter"
   :original-gravity-range [1.06 1.09]
   :ibu-range              [20 40]
   :srm-range              [17 30]
   :abv-range              [6.5 9.5]})

(def ^:const english-porter
  {:bjcp-category          :brown-british-beer
   :name                   "English Porter"
   :original-gravity-range [1.04 1.052]
   :ibu-range              [18 35]
   :srm-range              [20 30]
   :abv-range              [4 5.4]})

(def ^:const american-porter
  {:bjcp-category          :american-porter-and-stout
   :name                   "American Porter"
   :original-gravity-range [1.05 1.07]
   :ibu-range              [25 50]
   :srm-range              [22 40]
   :abv-range              [4.8 6.5]})

(def ^:const pre-prohibition-porter
  {:bjcp-category          :historical-beer
   :name                   "Pre-Prohibition Porter"
   :original-gravity-range [1.046 1.06]
   :ibu-range              [20 30]
   :srm-range              [18 30]
   :abv-range              [4.5 6]})

(def ^:const porter
  {:baltic-porter          baltic-porter
   :english-porter         english-porter
   :american-porter        american-porter
   :pre-prohibition-porter pre-prohibition-porter})
