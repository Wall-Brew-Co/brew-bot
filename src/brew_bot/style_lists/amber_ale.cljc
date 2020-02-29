(ns brew-bot.style-lists.amber-ale
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const altbier
  {:bjcp-category          :amber-bitter-european-beer
   :name                   "Altbier"
   :original-gravity-range [1.044 1.052]
   :ibu-range              [25 50]
   :srm-range              [11 17]
   :abv-range              [4.3 5.5]})

(def ^:const ordinary-bitter
  {:bjcp-category          :british-bitter
   :name                   "Ordinary Bitter"
   :original-gravity-range [1.03 1.039]
   :ibu-range              [25 35]
   :srm-range              [8 14]
   :abv-range              [3.2 3.8]})

(def ^:const best-bitter
  {:bjcp-category          :british-bitter
   :name                   "Best Bitter"
   :original-gravity-range [1.04 1.048]
   :ibu-range              [25 40]
   :srm-range              [8 16]
   :abv-range              [3.8 4.6]})

(def ^:const strong-bitter
  {:bjcp-category          :british-bitter
   :name                   "Strong Bitter"
   :original-gravity-range [1.048 1.06]
   :ibu-range              [30 50]
   :srm-range              [8 18]
   :abv-range              [4.6 6.2]})

(def ^:const scottish-light
  {:bjcp-category          :scottish-ale
   :name                   "Scottish Light"
   :original-gravity-range [1.03 1.035]
   :ibu-range              [10 20]
   :srm-range              [17 22]
   :abv-range              [2.5 3.2]})

(def ^:const scottish-heavy
  {:bjcp-category          :scottish-ale
   :name                   "Scottish Heavy"
   :original-gravity-range [1.035 1.04]
   :ibu-range              [10 20]
   :srm-range              [13 22]
   :abv-range              [3.2 3.9]})

(def ^:const scottish-export
  {:bjcp-category          :scottish-ale
   :name                   "Scottish Export"
   :original-gravity-range [1.04 1.06]
   :ibu-range              [15 30]
   :srm-range              [13 22]
   :abv-range              [3.9 6]})

(def ^:const irish-red-ale
  {:bjcp-category          :irish-beer
   :name                   "Irish Red Ale"
   :original-gravity-range [1.036 1.046]
   :ibu-range              [18 28]
   :srm-range              [9 14]
   :abv-range              [3.8 5]})

(def ^:const american-amber-ale
  {:bjcp-category          :amber-and-brown-american-beer
   :name                   "American Amber Ale"
   :original-gravity-range [1.045 1.06]
   :ibu-range              [25 40]
   :srm-range              [10 17]
   :abv-range              [4.5 6.2]})

(def ^:const biere-de-garde
  {:bjcp-category          :belgian-ale
   :name                   "Bière de Garde"
   :original-gravity-range [1.06 1.08]
   :ibu-range              [18 28]
   :srm-range              [6 19]
   :abv-range              [6 8.5]})

(def ^:const belgian-dubbel
  {:bjcp-category          :trappist-ale
   :name                   "Belgian Dubbel"
   :original-gravity-range [1.062 1.075]
   :ibu-range              [15 25]
   :srm-range              [10 17]
   :abv-range              [6 7.6]})

(def ^:const kentucky-common
  {:bjcp-category          :historical-beer
   :name                   "Kentucky Common"
   :original-gravity-range [1.044 1.055]
   :ibu-range              [15 30]
   :srm-range              [11 20]
   :abv-range              [4 5.5]})

(def ^:const amber-ale
  {:altbier            altbier
   :ordinary-bitter    ordinary-bitter
   :best-bitter        best-bitter
   :strong-bitter      strong-bitter
   :scottish-light     scottish-light
   :scottish-heavy     scottish-heavy
   :scottish-export    scottish-export
   :irish-red-ale      irish-red-ale
   :american-amber-ale american-amber-ale
   :biere-de-garde     biere-de-garde
   :belgian-dubbel     belgian-dubbel
   :kentucky-common    kentucky-common})
