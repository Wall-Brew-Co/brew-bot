(ns brew-bot.text-pages.not-found
  "Static text displayed on the 404: Not Found")

(defn not-found
  []
  [:div {:style {:max-width "50em"}}
   [:h2 "404: Page Not Found"]
   [:p "I'm sorry! "
    "I couldn't find what you were looking for. "
    "Please try one of the links on the left-hand side bar, or let "
    [:a {:href "https://github.com/nnichols/brew-bot/issues" :target "_blank"} "Nick know something went wrong"]]])
