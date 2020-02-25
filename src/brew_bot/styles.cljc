(ns brew-bot.styles
  "Convenience functions and refs to access recipe style data"
  (:require [brew-bot.style-lists.light-lager :as bbll]))

(def ^:const global-original-gravity-range
  [1.000 2.000])

(def ^:const global-ibu-range
  [0 150])

(def ^:const global-srm-range
  [0 40])

(def ^:const global-abv-range
  [0.0 100.0])

(defn score-range-delta
  "Determine on a normalized scale how close `data-point` was to `conforming-point` given the `scale`
   Shorter distances are scored higher, and currently this is determined linearly"
  [scale conforming-point data-point]
  (let [distance (Math/abs (- data-point conforming-point))
        fraction-of-scale (/ distance scale)]
    (- 1 fraction-of-scale)))

(defn score-adherence-to-range
  "Determine on a  normalized scale how well `data-point` fits in `local-range` w.r.t a `global-range`.
   Higher values indicate better fits.
   Assumes global-range and local-range to be order tuples"
  [global-range local-range data-point]
  (let [[global-low global-high] global-range
        [local-low  local-high]   local-range
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
  "Given a recipe and a codified beer style,
   return a normalized score on how well the recipe adheres to BJCP guideleines for that style"
  ;; TODO - Normalize attribute names between styles and recipes
  [recipe style]
  (let [og-adherence  (score-original-gravity-adherence (:original-gravity-range style) (:gravity recipe))
        ibu-adherence (score-ibu-adherence (:ibu-range style) (:ibu recipe))
        srm-adherence (score-srm-adherence (:srm-range style) (:sru-color recipe))
        abv-adherence (score-abv-adherence (:abv-range style) (:abv recipe))]
    (/ (+ og-adherence ibu-adherence srm-adherence abv-adherence) 4)))
