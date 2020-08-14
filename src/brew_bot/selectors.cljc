(ns brew-bot.selectors
  "Beer recipe generators"
  (:require [brew-bot.default-values :as defaults]
            [cljx-sampling.core :as rnd]
            [clojure.string :as cs]
            [common-beer-format.specs.hops :as hops]
            [nnichols.util :as nu]))

(defn selected-amount
  [selections]
  (let [amounts (map :amount selections)]
    (if (seq amounts)
      (apply + amounts)
      0)))

(defn make-random-selection
  [ingredients selections count-cutoff]
  (let [selected-ingredient (if (and (number? count-cutoff)
                                     (>= (count selections) count-cutoff))
                              (rand-nth selections)
                              (nu/rand-val ingredients))]
    (assoc selected-ingredient :amount (rand-nth defaults/ingredient-amounts))))

(defn select-ingredients-random
  "Assumptions:
   ingredients is a map of ingredient-keys to cbf conforming ingredients
   returned value is a list of cbf conforming ingredients"
  [ingredients {:keys [amount-cutoff count-cutoff]}]
  (let [amount-cutoff (or amount-cutoff defaults/amount-cutoff)]
    (loop [selections []]
      (if (>= (selected-amount selections) amount-cutoff)
        selections
        (let [selection (make-random-selection ingredients selections count-cutoff)]
          (recur (conj selections selection)))))))

(defn update-selection-probability
  [ingredient-key ingredient weights default-weight]
  (let [weight (get weights ingredient-key default-weight)]
    (assoc ingredient :probability weight)))

(defn update-selection-probabilities
  [ingredients weights default-weight]
  (let [reducing-fn (fn [m k v] (assoc m k (update-selection-probability k v weights default-weight)))
        weighted-ingredients (reduce-kv reducing-fn {} ingredients)]
    (nu/filter-by-values :probability weighted-ingredients)))

(defn make-weighted-selection
  [ingredients selections count-cutoff]
  (let [selection-set (if (and (number? count-cutoff)
                               (>= (count selections) count-cutoff))
                        selections
                        (vals ingredients))
        selection (first (rnd/sample selection-set :weigh :probability :replace true))]
    (assoc selection :amount defaults/minimum-ingredient-amount)))

(defn select-ingredients-weighted
  "Assumptions:
   ingredients is a map of ingredient-keys to cbf conforming ingredients
   returned value is a list of cbf conforming ingredients
   selection-weights is a map of ingredient-keys to numeric probability weights"
  [ingredients {:keys [amount-cutoff count-cutoff selection-weights default-weight]}]
  (let [amount-cutoff        (or amount-cutoff defaults/amount-cutoff)
        weighted-ingredients (update-selection-probabilities ingredients selection-weights default-weight)]
    (loop [selections []]
      (if (>= (selected-amount selections) amount-cutoff)
        (map #(dissoc % :probability) selections) ;; This key isn't part of the common-beer-format spec, so remove it
        (let [selection (make-weighted-selection weighted-ingredients selections count-cutoff)]
          (recur (conj selections selection)))))))

(defn random-hop-timing
  [hop]
  (assoc hop :use  (rand-nth (into [] hops/hop-uses))
             :time (rand-nth defaults/hop-times)))

(defn weighted-hop-timing
  [hop {:keys [use-weights time-weights]}]
  (assoc hop :use  (first (rnd/sample hops/hop-uses :weigh use-weights :replace true))
             :time (first (rnd/sample defaults/hop-times :weigh time-weights :replace true))))

(defn inferred-hop-timing
  [hop]
  (let [hop-type                   (cs/lower-case (str (:type hop)))
        [use-weights time-weights] (case hop-type
                                     "bittering" [defaults/bittering-hop-use-weights defaults/bittering-hop-time-weights]
                                     "aroma"     [defaults/aroma-hop-use-weights defaults/aroma-hop-time-weights]
                                     "both"      [defaults/both-hop-use-weights defaults/both-hop-time-weights])]
    (weighted-hop-timing hop {:use-weights use-weights :time-weights time-weights})))

(defn select-hop-timings
  [hops {:keys [timing-strategy] :as opts}]
  (let [strategy (or timing-strategy :random)
        selection-fn (case strategy
                       :random   random-hop-timing
                       :weighted (nu/rpartial weighted-hop-timing opts)
                       :inferred inferred-hop-timing)]
    (map selection-fn hops)))
