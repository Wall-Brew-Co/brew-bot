(ns brew-bot.visual-identity.components
  "Common re-frame/ANTD components"
  (:require [brew-bot.visual-identity.colors :as colors]
            [re-frame.core :as rf]))

(defn dividing-bar
  ([attrs]
   [:hr (merge-with merge {:style {:margin           "-1px 0px 0px"
                                   :height           "1px"
                                   :border           "none"
                                   :background-color colors/dark-gray}} attrs)])

  ([]
   [dividing-bar {}]))

(defn linked-item
  "A stylized pseudo-link that triggers re-frame navigation"
  ([route route-text]
   [linked-item route route-text route-text])

  ([route route-text route-title]
   [:b {:style {:color colors/dark-blue :text-decoration "underline" :cursor "pointer"}
        :title route-title
        :on-click #(rf/dispatch [:navigate route])} route-text]))
