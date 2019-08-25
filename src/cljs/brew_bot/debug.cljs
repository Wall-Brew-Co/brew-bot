(ns brew-bot.debug
  "Namespace providing utilities for debugging using JS Console in non-local environments."
  (:require [re-frame.db :as rf-db]))

(defn ^:export app-db
  []
  @rf-db/app-db)

(defn ^:export app-db-js
  []
  (clj->js (app-db)))
