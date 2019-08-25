(ns brew-bot.main
  "Application launcher for the web UI"
  (:require [brew-bot.layout :as layout]
            [reagent.core :as r]
            [re-frame.core :as rf]

            ;; All Event/Sub namespaces must be included to load properly
            [brew-bot.events]
            [brew-bot.subs]))

(defn mount-root
  "Render the main app panel, and mount it to the window"
  []
  (r/render [layout/main-panel] (.getElementById js/document "app")))

(defn ^:export init
  "Initialize the app db, and mount the application.
  Exported to preserve fn name through advanced compilation name munging"
  []
  (rf/dispatch-sync [:initialize-db])
  (mount-root))
