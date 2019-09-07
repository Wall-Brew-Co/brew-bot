(ns brew-bot.events
  (:require [brew-bot.db :as db]
            [re-frame.core :as rf]))

(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   db/default-db))

(rf/reg-event-fx
 :reset-db
 (fn [{db :db} [_ page]]
   {:db (merge db db/default-db)
    :dispatch [:update-current-page page]}))

(rf/reg-event-db
  :update-current-page
  (fn [db [_ page]]
    (assoc db :current-page page)))

(rf/reg-event-db
  :no-op
  (fn [db _] db))
