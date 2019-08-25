(ns brew-bot.layout
  (:require [re-frame.core :as rf]))

(defn main-panel
  []
  (let [app-name @(rf/subscribe [:app-name])]
    (fn []
      [:div (str "Welcome to " app-name)])))
