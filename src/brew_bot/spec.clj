(ns brew-bot.spec
  "Common specs/api checks for core functions"
  (:require [clojure.spec.alpha :as s]))

(s/def ::name string?)
(s/def ::product-number string?)
(s/def ::manufacturer string?)

(s/def ::gravity
  (s/and number?
         #(>= % 1.0)))

(s/def ::alpha
  (s/and number?
         #(>= % 1.0)))

(s/def ::beta
  (s/and number?
         #(>= % 1.0)))

(s/def ::weight
  (s/and number?
         #(>= % 0.25)))

(s/def ::grain (s/keys :req-un [::name ::gravity]))
(s/def ::hop (s/keys :req-un [::name ::alpha ::beta]))
(s/def ::extract (s/keys :req-un [::name ::gravity]))
(s/def ::yeast (s/keys :req-un [::name ::product-number ::manufacturer]))
