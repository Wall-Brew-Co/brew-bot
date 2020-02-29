(ns brew-bot.style-lists.strong-ale
  "Pre-determined style weights and definitions based on BJCP guidelines")

(def ^:const british-strong-ale
  {:bjcp-category          :strong-british-ale
   :name                   "British Strong Ale"
   :original-gravity-range [1.055 1.08]
   :ibu-range              [30 60]
   :srm-range              [8 22]
   :abv-range              [5.5 8]})

(def ^:const old-ale
  {:bjcp-category          :strong-british-ale
   :name                   "Old Ale"
   :original-gravity-range [1.055 1.088]
   :ibu-range              [30 60]
   :srm-range              [10 22]
   :abv-range              [5.5 9]})

(def ^:const wee-heavy
  {:bjcp-category          :strong-british-ale
   :name                   "Wee Heavy"
   :original-gravity-range [1.07 1.13]
   :ibu-range              [17 35]
   :srm-range              [14 25]
   :abv-range              [6.5 10]})

(def ^:const english-barleywine
  {:bjcp-category          :strong-british-ale
   :name                   "English Barleywine"
   :original-gravity-range [1.08 1.12]
   :ibu-range              [35 70]
   :srm-range              [8 22]
   :abv-range              [8 12]})

(def ^:const american-strong-ale
  {:bjcp-category          :strong-american-ale
   :name                   "American Strong Ale"
   :original-gravity-range [1.062 1.09]
   :ibu-range              [50 100]
   :srm-range              [7 19]
   :abv-range              [6.3 10]})

(def ^:const american-barleywine
  {:bjcp-category          :strong-american-ale
   :name                   "American Barleywine"
   :original-gravity-range [1.08 1.12]
   :ibu-range              [50 100]
   :srm-range              [10 19]
   :abv-range              [8 12]})

(def ^:const wheatwine
  {:bjcp-category          :strong-american-ale
   :name                   "Wheatwine"
   :original-gravity-range [1.08 1.12]
   :ibu-range              [30 60]
   :srm-range              [8 15]
   :abv-range              [8 12]})

(def ^:const belgian-golden-strong-ale
  {:bjcp-category          :strong-belgian-ale
   :name                   "Belgian Golden Strong Ale"
   :original-gravity-range [1.07 1.095]
   :ibu-range              [22 35]
   :srm-range              [3 6]
   :abv-range              [7.5 10.5]})

(def ^:const belgian-tripel
  {:bjcp-category          :trappist-ale
   :name                   "Belgian Tripel"
   :original-gravity-range [1.075 1.085]
   :ibu-range              [20 40]
   :srm-range              [4.5 7]
   :abv-range              [7.5 9.5]})

(def ^:const belgian-dark-strong-ale
  {:bjcp-category          :trappist-ale
   :name                   "Belgian Dark Strong Ale"
   :original-gravity-range [1.075 1.11]
   :ibu-range              [20 35]
   :srm-range              [12 22]
   :abv-range              [8 12]})

(def ^:const strong-ale
  {:british-strong-ale        british-strong-ale
   :old-ale                   old-ale
   :wee-heavy                 wee-heavy
   :english-barleywine        english-barleywine
   :american-strong-ale       american-strong-ale
   :american-barleywine       american-barleywine
   :wheatwine                 wheatwine
   :belgian-golden-strong-ale belgian-golden-strong-ale
   :belgian-tripel            belgian-tripel
   :belgian-dark-strong-ale   belgian-dark-strong-ale})
