(ns brew-bot.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub :app-name
  (fn [db _]
    (:app-name db)))
