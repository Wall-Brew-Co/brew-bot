(ns brew-bot.selectors
  "Beer recipe generators"
  (:require [brew-bot.default-values :as defaults]
            [cljx-sampling.core :as rnd]
            [clojure.string :as cs]
            [common-beer-format.specs.hops :as hops]
            [nnichols.util :as nu]))


(defn selected-amount
  "Given a list of ingredients, return the total amount of ingredients"
  [selections]
  (let [amounts (map :amount selections)]
    (if (seq amounts)
      (apply + amounts)
      0)))


(defn make-random-selection
  "Make a random selection from `ingredients`.
   If the number of `selections` is already at the `count-cutoff`, and a `count-cutoff` has been selected, don't pick new ingredients."
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
  "Add the relevant :probability of `ingredient`'s selection.
   If no match is found in `weights` fall-back to `default-weight`"
  [ingredient-key ingredient weights default-weight]
  (let [weight (get weights ingredient-key default-weight)]
    (assoc ingredient :probability weight)))


(defn update-selection-probabilities
  [ingredients weights default-weight]
  (let [reducing-fn          (fn [m k v] (assoc m k (update-selection-probability k v weights default-weight)))
        weighted-ingredients (reduce-kv reducing-fn {} ingredients)
        probabilities        (nu/filter-by-values :probability weighted-ingredients)]
    (if (empty? probabilities)
      (throw (ex-info "No matching :selection-weights were provided and no :default-weight was declared" {:weights weights}))
      probabilities)))


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
  "Select a random hop use and timing"
  [hop]
  (assoc hop :use  (rand-nth (into [] hops/hop-uses))
         :time (rand-nth defaults/hop-times)))


(defn weighted-hop-timing
  "Select hop timings and uses with the provided weights"
  [hop {:keys [use-weights time-weights]}]
  (assoc hop :use  (first (rnd/sample hops/hop-uses :weigh use-weights :replace true))
         :time (first (rnd/sample defaults/hop-times :weigh time-weights :replace true))))


(defn inferred-hop-timing
  "Select hop timings and uses based on the hop's type.
   Bittering hops will often be boiled for longer, and aroma hops are biased towards short boils and secondary additions."
  [hop]
  (let [hop-type                   (cs/lower-case (str (:type hop)))
        [use-weights time-weights] (case hop-type
                                     "bittering" [defaults/bittering-hop-use-weights defaults/bittering-hop-time-weights]
                                     "aroma"     [defaults/aroma-hop-use-weights defaults/aroma-hop-time-weights]
                                     "both"      [defaults/both-hop-use-weights defaults/both-hop-time-weights])]
    (weighted-hop-timing hop {:use-weights use-weights :time-weights time-weights})))


(defn select-hop-timings
  "Given a common-beer-format hop and option map, update hop timings and uses.
   TODO : Allow use-weights and time-weights to differ by hop"
  [hops {:keys [timing-strategy] :as opts}]
  (let [strategy (or timing-strategy :random)
        selection-fn (case strategy
                       :random   random-hop-timing
                       :weighted (nu/rpartial weighted-hop-timing opts)
                       :inferred inferred-hop-timing)]
    (map selection-fn hops)))
