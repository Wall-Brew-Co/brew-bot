(ns brew-bot.main
  "Application launcher for the web UI"
  (:require [brew-bot.layout :as layout]
            [brew-bot.routes :as routes]
            [district0x.re-frame.google-analytics-fx]
            [reagent.core :as r]
            [re-frame.core :as rf]

            ;; All Event/Sub namespaces must be included to load properly
            [brew-bot.debug]
            [brew-bot.events]
            [brew-bot.subs]
            [brew-bot.recipe-generation.events]
            [brew-bot.recipe-generation.subs]
            [brew-bot.recipe-generation.weights]))

(enable-console-print!)

(defn mount-root
  "Render the main app panel, and mount it to the window"
  []
  (rf/clear-subscription-cache!)
  (r/render [#'layout/main-panel] (.getElementById js/document "app")))

(defn ^:export init
  "Initialize the app db, and mount the application.
  Exported to preserve fn name through advanced compilation name munging"
  []
  (district0x.re-frame.google-analytics-fx/set-enabled! true)
  (rf/dispatch [:initialize-db])
  (mount-root))
