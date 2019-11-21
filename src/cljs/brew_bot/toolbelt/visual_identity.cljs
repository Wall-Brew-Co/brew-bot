(ns brew-bot.toolbelt.visual-identity
  "Common CSS styles, colors, etc.")

(def ^:const dim-gray "#9C9C9C")
(def ^:const dark-gray "#242729")
(def ^:const dark-blue "#001529")

(defn dividing-bar
  ([attrs]
   [:hr (merge-with merge {:style {:margin           "-1px 0px 0px"
                                   :height           "1px"
                                   :border           "none"
                                   :background-color dark-gray}} attrs)])

  ([]
   [dividing-bar {}]))
