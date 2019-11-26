(ns brew-bot.text-pages.home-page
  "Static text displayed on the landing page"
  (:require [brew-bot.visual-identity.colors :as colors]
            [re-frame.core :as rf]))

(defn linked-item
  [route route-text description]
  [:li
   [:b {:style {:color colors/dark-blue :text-decoration "underline" :cursor "pointer" :margin "1em 0"}
        :title (str "Try out the " route-text " recipe generator!")
        :on-click #(rf/dispatch [:navigate route])} (str route-text ":")] (str " " description)])

(defn home-page
  []
  [:div {:style {:max-width "50em"}}
   [:h2 "Welcome to brew-bot!"]
   [:p "I'm an autonomous beer recipe generator developed by " [:a {:href "https://github.com/nnichols" :target "_blank"} "Nick Nichols. "]
    "You can try out one of my recipe generation modes by using the links below or to your left."]

   [:ul
    [linked-item "/generators/random"          "Purely Random" "brew-bot will randomly select ingredients and quantities up to the set weight limit."]
    [linked-item "/generators/limited-random"  "Constrained Random" "brew-bot will randomly select ingredients and quantities up to the set weight limit, selecting no more ingredients than the set limit."]
    [linked-item "/generators/weighted-random" "Weighted Random" "brew-bot will allow the user to select ingredients to adjust their relative selection probabilities, and randomly pick ingredients from the full list respecting the user-selected weights."]
    [linked-item "/generators/weighted-guided" "Weighted Guided" "brew-bot will allow the user to select ingredients to adjust their relative selection probabilities, and randomly pick ingredients from the that list respecting the user-selected weights."]
    [:li [:b {:style {:color colors/dark-blue}} "COMING SOON - Weighted Observed:"] " brew-bot will utilize weights learned from scraping real world beer recipes by style."]]])
