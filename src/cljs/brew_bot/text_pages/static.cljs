(ns brew-bot.text-pages.static-content
  "Static text displayed on the About Me Page"
  (:require [brew-bot.text-pages.about-me :as am]
            [brew-bot.text-pages.contributors :as contrib]
            [brew-bot.text-pages.home-page :as hp]
            [brew-bot.text-pages.not-found :as nf]
            [brew-bot.text-pages.random-generators :as ran-gen]
            [brew-bot.text-pages.weighted-generators :as wei-gen]
            [brew-bot.text-pages.contributors :as contrib]))

(def about-me am/about-me)
(def home-page hp/home-page)
(def random-generators ran-gen/random-generators)
(def weighted-generators wei-gen/weighted-generators)
(def contributors contrib/contributors)
(def not-found nf/not-found)
