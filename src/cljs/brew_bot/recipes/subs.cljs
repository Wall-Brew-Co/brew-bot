(ns brew-bot.recipes.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
 :generated-recipe
 (fn [db _]
   (:generated-recipe db)))
