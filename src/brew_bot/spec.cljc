(ns brew-bot.spec
  "Common specs/api checks for core functions"
  (:require [brew-bot.ingredients :as ingredients]
            [clojure.spec.alpha :as s]))

(s/def ::name string?)
(s/def ::product-number string?)
(s/def ::manufacturer string?)
(s/def ::bjcp-category keyword?)

(s/def ::gravity
  (s/and number?
         #(>= % 1.0)))

(s/def ::lovibond
  (s/and number?
         #(>= % 0.5)))

(s/def ::tags map?)

(s/def ::suggested-max
  (s/and number?
         #(>= % 0.25)))

(s/def ::alpha
  (s/and number?
         #(>= % 1.0)))

(s/def ::beta
  (s/and number?
         #(>= % 1.0)))

(s/def ::weight
  (s/and number?
         #(>= % 0.25)))

(s/def ::time-boiled
  (s/and number?
         #((set ingredients/hop-times) %)))

(s/def ::grain
  (s/keys :req-un [::name ::gravity ::lovibond ::tags ::suggested-max]
          :opt-un [::weight]))

(s/def ::grains
  (s/map-of ingredients/grains-keys ::grain))

(s/def ::hop
  (s/keys :req-un [::name ::alpha ::beta ::tags]
          :opt-un [::weight ::time-boiled]))

(s/def ::hops
  (s/map-of ingredients/hops-keys ::hop))

(s/def ::extract
  (s/keys :req-un [::name ::gravity ::lovibond ::suggested-max]
          :opt-un [::weight ::tags]))

(s/def ::extracts
  (s/map-of ingredients/extracts-keys ::extract))

(s/def ::yeast
  (s/keys :req-un [::name ::product-number ::manufacturer]
          :opt-un [::tags]))

(s/def ::yeasts
  (s/map-of ingredients/yeasts-keys ::yeast))

(s/def ::recipe
  (s/keys :req-un [::grains ::hops ::yeasts ::gravity]
          :opt-un [::extracts]))

(s/def ::original-gravity-range 
  (s/and vector?
         #(= 2 (count %))
         #(every? number? %)
         #(< (first %) (second %))))

(s/def ::ibu-range
  (s/and vector?
         #(= 2 (count %))
         #(every? number? %)
         #(< (first %) (second %))))

(s/def ::srm-range
  (s/and vector?
         #(= 2 (count %))
         #(every? number? %)
         #(< (first %) (second %))))

(s/def ::abv-range
  (s/and vector?
         #(= 2 (count %))
         #(every? number? %)
         #(< (first %) (second %))))
         
(s/def ::bjcp-style
  (s/keys :req-un [::original-gravity-range ::ibu-range ::srm-range ::abv-range ::name ::bjcp-category]))
