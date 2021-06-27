(ns brew-bot.styles
  "Convenience functions and refs to access recipe style data"
  (:require [brew-bot.util :as util]
            [common-beer-format.data.data :as styles]))


(def ^:const global-original-gravity-range
  [1.000 2.000])


(def ^:const global-ibu-range
  [0 150])


(def ^:const global-srm-range
  [0 40])


(def ^:const global-abv-range
  [0.0 1.0])


(defn score-range-delta
  "Determine on a normalized scale how close `data-point` was to `conforming-point` given the `scale`
   Shorter distances are scored higher, and currently this is determined quadratically"
  [scale conforming-point data-point]
  (let [distance (Math/abs (- data-point conforming-point))
        fraction-of-scale (/ distance scale)]
    (Math/pow (- 1 fraction-of-scale) 2.0)))


(defn score-adherence-to-range
  "Determine on a  normalized scale how well `data-point` fits in `local-range` w.r.t a `global-range`.
   Higher values indicate better fits.
   Assumes global-range and local-range to be order tuples"
  [global-range local-range data-point]
  (let [[global-low global-high] global-range
        [local-low local-high] local-range
        scale (- global-high global-low)]
    (cond

      ;; Detect points that are effectively out of bounds
      (>= data-point global-high) 0
      (<= data-point global-low)  0

      ;; Detect when we're within the local range
      (and (<= data-point local-high)
           (>= data-point local-low)) 1

      ;; Detect when we're between the global and local low values
      (< data-point local-low) (score-range-delta scale local-low data-point)

      (> data-point local-high) (score-range-delta scale local-high data-point)

      :else (throw (ex-info "Illegal State in score-adherence-to-range" {:global-low  global-low
                                                                         :global-high global-high
                                                                         :local-low   local-low
                                                                         :local-high  local-high
                                                                         :data-point  data-point})))))


(def score-original-gravity-adherence
  (partial score-adherence-to-range global-original-gravity-range))


(def score-ibu-adherence
  (partial score-adherence-to-range global-ibu-range))


(def score-srm-adherence
  (partial score-adherence-to-range global-srm-range))


(def score-abv-adherence
  (partial score-adherence-to-range global-abv-range))


(defn score-style-adherence
  "Given a common-beer-format recipe's `gravity`, `ibu`, `srm`, and `abv`,
   return a normalized score on how well the recipe adheres to BJCP guideleines for that style"
  [gravity ibu srm abv style]
  (let [og-range      [(:og-min style) (:og-max style)]
        ibu-range     [(:ibu-min style) (:ibu-max style)]
        srm-range     [(:color-min style) (:color-max style)]
        abv-range     [(:abv-min style) (:abv-max style)]
        og-adherence  (score-original-gravity-adherence og-range gravity)
        ibu-adherence (score-ibu-adherence ibu-range ibu)
        srm-adherence (score-srm-adherence srm-range srm)
        abv-adherence (score-abv-adherence abv-range abv)]
    (* og-adherence ibu-adherence srm-adherence abv-adherence)))


(defn score-against-styles
  "Given a common-beer-format recipe's `gravity`, `ibu`, `srm`, and `abv`,
   return a map from BJCP styles to the normalized value of the recipe's conformance to that style"
  [gravity ibu srm abv]
  (let [reducing-fn (fn [m k v]
                      (let [score (score-style-adherence gravity ibu srm abv v)]
                        (assoc m k score)))]
    (reduce-kv reducing-fn {} styles/all-style-guides)))


(defn best-match
  "Given a common-beer-format recipe's `gravity`, `ibu`, `srm`, and `abv`,
   return the closest BJCP style that matches those data points."
  [gravity ibu srm abv]
  (let [style-scores (score-against-styles gravity ibu srm abv)
        closest-key  (ffirst (util/max-n-kv style-scores 1))]
    (get styles/all-style-guides closest-key)))
