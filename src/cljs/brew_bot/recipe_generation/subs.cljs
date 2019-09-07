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
 :generated-recipe
 (fn [db _]
   (:generated-recipe db)))
