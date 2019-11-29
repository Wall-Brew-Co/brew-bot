(ns brew-bot.recipe-generation.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
 :source-ingredients
 (fn [db _]
   (:recipe-sources db)))

(rf/reg-sub
 :current-recipe
 (fn [db _]
   (:current-recipe db)))

(rf/reg-sub
 :has-recipe-changed?
 (fn [db _]
   (get-in db [:current-recipe :has-recipe-changed?])))

(rf/reg-sub
 :generator-type
 (fn [db _]
   (get-in db [:current-recipe :generator])))

(rf/reg-sub
 :is-ingredient-type-hidden?
 (fn [db [_ ingredient-type]]
   (get-in db [:recipe-generator ingredient-type :invisible?])))
