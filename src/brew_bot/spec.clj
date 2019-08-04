(ns brew-bot.spec
  "Common specs/api checks for core functions"
  (:require [clojure.spec.alpha :as s]))

(s/def ::ingredient-name string?)

(s/def ::gravity
  (s/and number?
         #(>= % 1.0)))

(s/def ::weight
  (s/and number?
         #(>= % 0.25)))

(s/def ::hop-acid
  (s/and number?
         #(>= % 1.0)))

(s/def ::product-number string?)
(s/def ::manufacturer string?)
