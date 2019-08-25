(ns brew-bot.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub :current-page
  (fn [db _]
    (:current-page db)))

(rf/reg-sub :current-recipe-grains
  (fn [db _]
    (get-in db [:recipe-sources :grains])))

(rf/reg-sub :current-recipe-extracts
  (fn [db _]
    (get-in db [:recipe-sources :extracts])))

(rf/reg-sub :current-recipe-hops
  (fn [db _]
    (get-in db [:recipe-sources :hops])))

(rf/reg-sub :current-recipe-yeasts
  (fn [db _]
    (get-in db [:recipe-sources :yeasts])))
