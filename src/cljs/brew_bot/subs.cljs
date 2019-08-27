(ns brew-bot.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub :current-page
  (fn [db _]
    (:current-page db)))
