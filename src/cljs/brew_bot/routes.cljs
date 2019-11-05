(ns brew-bot.routes
  "Inner-app navigation"
  (:require [secretary.core :as secretary :refer-macros [defroute]]
            [brew-bot.events]
            [goog.events :as events]
            [goog.history.EventType :as HistoryEventType]
            [goog.object]
            [reagent.core :as r]
            [re-frame.core :as rf])
  (:import [goog History]
           [goog.history EventType]))

(defonce history
  (atom nil))

(rf/reg-event-fx
 :hash-changed
 (fn [{:keys [db]} [_ route]]
   (let [evts (secretary/dispatch! route)
         _ (println (str "naviagted to " route))]
     {:dispatch-n   evts
      ;:ga/page-view [route]
})))

(rf/reg-event-fx
  ;when updating db and navigating from a single event, it is important to use the :navigate event,
  ;your db needs to be updated before the navigate event runs
 :navigate
 (fn [_ [_ loc]]
   {:navigate loc}))

(rf/reg-fx
 :navigate
 (fn [loc]
   (if (= (str "#" loc) (.-hash js/window.location))
     (doto @history
        ; This is a hack that allows to trigger routing when navigating to the current page.
        ; Normally, History will not trigger it's events in this case.
       (.setEnabled false)
       (.setEnabled true))
     (set! (.-hash js/window.location) loc))))

(defn- hook-browser-navigation! []
  (reset! history
          (doto (History.)
            (events/listen
             EventType/NAVIGATE
             (fn [event]
               (rf/dispatch [:hash-changed (.-token event)])))
            (.setEnabled true))))

;; ROUTES
(secretary/defroute "/"
  {:keys [query-params]}
  [[:initialize-db]])

(secretary/defroute "/generators/:generator-type"
  {:keys [generator-type]}
  [[:update-current-page (keyword generator-type)]])

(secretary/defroute "/about-me"
  {:as params}
  [[:update-current-page :about]])

;; This must execute last
(hook-browser-navigation!)
