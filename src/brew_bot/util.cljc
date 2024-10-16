(ns brew-bot.util
  "Common fns required across brew-bot"
  (:require [com.wallbrew.spoon.string :as spoon.string]))


(defn max-n-kv
  "Given `m` with k-v pairs for which all values are numbers, return the `n` k-v pairs with the highest values"
  [m n]
  (let [ordered-tuples (take n (sort-by (comp - last) m))
        list-of-maps   (map #(hash-map (first %) (second %)) ordered-tuples)]
    (apply merge list-of-maps)))


(defn min-n-kv
  "Given `m` with k-v pairs for which all values are numbers, return the `n` k-v pairs with the lowest values"
  [m n]
  (let [ordered-tuples (take n (sort-by last m))
        list-of-maps   (map #(hash-map (first %) (second %)) ordered-tuples)]
    (apply merge list-of-maps)))


(defn fermentables->cbf-fermentables
  "Given a vector of common-beer-format conforming ::fermentable maps, convert them to a ::fermentables record"
  [fermentables]
  (let [grouped-fermentables (vals (group-by :name fermentables))
        collapsing-fn        (fn [ferm] (assoc (first ferm) :amount (apply + (map :amount ferm))))
        fermentables         (map collapsing-fn grouped-fermentables)]
    (map #(hash-map :fermentable %) fermentables)))


(defn hops->cbf-hops
  "Given a vector of common-beer-format conforming ::hop maps, convert them to a ::hops record"
  [hops]
  (let [grouping-fn   (fn [hop] [(:name hop) (:time hop) (:use hop)])
        grouped-hops  (vals (group-by grouping-fn hops))
        collapsing-fn (fn [hop] (assoc (first hop) :amount (apply + (map :amount hop))))
        hops          (map collapsing-fn grouped-hops)]
    (map #(hash-map :hop %) hops)))


(defn yeasts->cbf-yeasts
  "Given a vector of common-beer-format conforming ::yeast maps, convert them to a ::yeasts record"
  [yeasts]
  (let [grouped-yeasts (vals (group-by :name yeasts))
        collapsing-fn  (fn [yeast] (assoc (first yeast) :amount (apply + (map :amount yeast))))
        yeasts         (map collapsing-fn grouped-yeasts)]
    (map #(hash-map :yeast %) yeasts)))


(defn determine-recipe-type
  "Given a vector of common-beer-format conforming ::fermentable maps, determine if the recipe is 'Extract', 'Partial Mash', or 'All Grain'"
  [fermentables]
  (let [all-grain? (and (seq fermentables)
                        (every? #(spoon.string/same-text? "grain" (:type %)) fermentables))
        all-extract? (and (seq fermentables)
                          (every? #(contains? #{"sugar" "extract" "dry extract"} (spoon.string/prepare-for-compare (:type %))) fermentables))]
    (cond
      all-grain?            "All Grain"
      all-extract?          "Extract"
      (empty? fermentables) (throw (ex-info "Cannot determine recipe type with an empty collection of fermentables" {}))
      :else                 "Partial Mash")))


(defn determine-boil-time
  "Given a vector of common-beer-format conforming ::hop maps, determine the longest necessary boil time for alpha acid extraction.
   In the case of an abnormally short boil, default to 60 minutes."
  [hops]
  (let [hop-times (conj (map :time hops) 60)]
    (apply max hop-times)))
