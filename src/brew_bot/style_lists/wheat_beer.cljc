(ns brew-bot.style-lists.wheat-beer
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const american-wheat-beer
  {:bjcp-category          :standard-american-beer
   :name                   "American Wheat Beer"
   :original-gravity-range [1.04 1.055]
   :ibu-range              [15 30]
   :srm-range              [3 6]
   :abv-range              [4 5.5]})

(def ^:const weissbier
  {:bjcp-category          :german-wheat-beer
   :name                   "Weissbier"
   :original-gravity-range [1.044 1.052]
   :ibu-range              [8 15]
   :srm-range              [2 6]
   :abv-range              [4.3 5.6]})

(def ^:const dunkles-weissbier
  {:bjcp-category          :german-wheat-beer
   :name                   "Dunkles Weissbier"
   :original-gravity-range [1.044 1.056]
   :ibu-range              [10 18]
   :srm-range              [14 23]
   :abv-range              [4.3 5.6]})

(def ^:const weizenbock
  {:bjcp-category          :german-wheat-beer
   :name                   "Weizenbock"
   :original-gravity-range [1.064 1.09]
   :ibu-range              [15 30]
   :srm-range              [6 25]
   :abv-range              [6.5 9]})

(def ^:const berliner-weisse
  {:bjcp-category          :european-sour-ale
   :name                   "Berliner Weisse"
   :original-gravity-range [1.028 1.032]
   :ibu-range              [3 8]
   :srm-range              [2 3]
   :abv-range              [2.8 3.8]})

(def ^:const lambic
  {:bjcp-category          :european-sour-ale
   :name                   "Lambic"
   :original-gravity-range [1.04 1.054]
   :ibu-range              [0 10]
   :srm-range              [3 7]
   :abv-range              [5 6.5]})

(def ^:const gueuze
  {:bjcp-category          :european-sour-ale
   :name                   "Gueuze"
   :original-gravity-range [1.04 1.06]
   :ibu-range              [0 10]
   :srm-range              [3 7]
   :abv-range              [5 8]})

(def ^:const fruit-lambic
  {:bjcp-category          :european-sour-ale
   :name                   "Fruit Lambic"
   :original-gravity-range [1.04 1.06]
   :ibu-range              [0 10]
   :srm-range              [3 7]
   :abv-range              [5 7]})

(def ^:const witbier
  {:bjcp-category          :belgian-ale
   :name                   "Witbier"
   :original-gravity-range [1.044 1.052]
   :ibu-range              [8 20]
   :srm-range              [2 4]
   :abv-range              [4.5 5.5]})

(def ^:const gose
  {:bjcp-category          :historical-beer
   :name                   "Gose"
   :original-gravity-range [1.036 1.056]
   :ibu-range              [5 12]
   :srm-range              [3 4]
   :abv-range              [4.2 4.8]})

(def ^:const lichtenhainer
  {:bjcp-category          :historical-beer
   :name                   "Lichtenhainer"
   :original-gravity-range [1.032 1.04]
   :ibu-range              [5 12]
   :srm-range              [3 6]
   :abv-range              [3.5 4.7]})

(def ^:const piwo-grodziskie
  {:bjcp-category          :historical-beer
   :name                   "Piwo Grodziskie"
   :original-gravity-range [1.028 1.032]
   :ibu-range              [20 35]
   :srm-range              [3 6]
   :abv-range              [2.5 3.3]})

(def ^:const roggenbier
  {:bjcp-category          :historical-beer
   :name                   "Roggenbier"
   :original-gravity-range [1.046 1.056]
   :ibu-range              [10 20]
   :srm-range              [14 19]
   :abv-range              [4.5 6]})

(def ^:const sahti
  {:bjcp-category          :historical-beer
   :name                   "Sahti"
   :original-gravity-range [1.076 1.12]
   :ibu-range              [7 15]
   :srm-range              [4 22]
   :abv-range              [7 11]})

(def ^:const wheat-beer
  {:american-wheat-beer american-wheat-beer
   :weissbier           weissbier
   :dunkles-weissbier   dunkles-weissbier
   :weizenbock          weizenbock
   :berliner-weisse     berliner-weisse
   :lambic              lambic
   :gueuze              gueuze
   :fruit-lambic        fruit-lambic
   :witbier             witbier
   :gose                gose
   :lichtenhainer       lichtenhainer
   :piwo-grodziskie     piwo-grodziskie
   :roggenbier          roggenbier
   :sahti               sahti})
