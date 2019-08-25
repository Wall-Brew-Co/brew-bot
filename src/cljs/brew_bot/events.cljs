(ns brew-bot.events
  (:require [brew-bot.db :as db]
            [re-frame.core :as rf]))

(rf/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(rf/reg-event-db
  :update-current-page
  (fn [db [_ page]]
    (assoc db :current-page page)))
