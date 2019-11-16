(ns brew-bot.text-pages.contributors
  "Honorary list of contributors")

(defn contributors
  []
  [:div {:style {:max-width "50em"}}
   [:h2 "Contributors"]
   [:p "brew-bot is free and open source software, and would not be possible without the help of the community. "
    "As a courtesy to those who have spent time on brew-bot, we've decided to thank them here. "
    "If you think your name should be one this list, please let Nick know. "
    "Likewise, if you are on this list and wish not to be, please let us know as well."]

   [:h3 "Owner"]
   [:ul
    [:li [:a {:href "https://github.com/nnichols" :target "_blank"} "Nick Nichols"]]]

   [:h3 "Contributors - Chronologically"]
   [:ul
    [:li [:a {:href "https://github.com/Dareknotderek" :target "_blank"} "Dariusz Jakubowski"]]
    [:li [:a {:href "https://github.com/kix" :target "_blank"} "Stepan Anchugov"]]]])
