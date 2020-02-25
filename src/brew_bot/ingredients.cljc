(ns brew-bot.ingredients
  "Convenience functions and refs to access ingredient data"
  (:require [brew-bot.ingredient-lists.grains :as bbg]
            [brew-bot.ingredient-lists.hops :as bbh]
            [brew-bot.ingredient-lists.extracts :as bbe]
            [brew-bot.ingredient-lists.yeasts :as bby]))

;; Convenience defs so users only have to load ingredients from 1 namespace
(def grains bbg/grains)
(def hops bbh/hops)
(def extracts bbe/extracts)
(def yeasts bby/yeasts)

(def ^:const grains-keys
  (set (keys bbg/grains)))

(def ^:const hops-keys
  (set (keys bbh/hops)))

(def ^:const extracts-keys
  (set (keys bbe/extracts)))

(def ^:const yeasts-keys
  (set (keys bby/yeasts)))

(def ^:const ingredient-amounts
  [0.25 0.5 0.75 1.0])

(def ^:const hop-times
  [120 90 60 45 30 15 10 5 1])
