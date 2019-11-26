(ns brew-bot.visual-identity.components
  "Common re-frame/ANTD components"
  (:require [brew-bot.visual-identity.colors :as colors]))

(defn dividing-bar
  ([attrs]
   [:hr (merge-with merge {:style {:margin           "-1px 0px 0px"
                                   :height           "1px"
                                   :border           "none"
                                   :background-color colors/dark-gray}} attrs)])

  ([]
   [dividing-bar {}]))
