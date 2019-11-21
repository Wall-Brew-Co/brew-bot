(ns brew-bot.text-pages.random-generators
  "Static text about the random recipe generators"
  (:require [brew-bot.toolbelt.visual-identity :as vi]
            [re-frame.core :as rf]))

(defn linked-item
  [route route-text]
   [:b {:style {:color vi/dark-blue :text-decoration "underline" :cursor "pointer"}
        :title (str "Try out the " route-text " recipe generator!")
        :on-click #(rf/dispatch [:navigate route])} route-text])

(defn random-generators
  []
  [:div {:style {:max-width "50em"}}
   [:h2 "Random Generators"]

   [:p
   "What is a beer recipe? "
   "Generally, we think of it as a collection of grains, hops, yeast, and potentially malt extract measured in exact amounts. "
   "With that naive understanding, it’s easy to imagine how we can generate purely random recipes. "
   "Generate a random collection of ingredients, and then assign a random amount to each ingredient. "]

   [:p
    "When we look at the " [linked-item "/generators/random" "Purely Random"] " recipe generator, it does exactly that. "
    "Brew-bot repeatedly looks through its lists of ingredients and selects random ones. "
    "The ones it picks are added to the recipe, and, if it ever picks the same thing twice, it adds the weights together. "
    "That’s it. "
    "There’s no deeper analysis to see what makes sense, what styles it may match, or if it’ll taste good."]

   [:p
    "To use it, just select the number of gallons you’d be fermenting, as well as the maximum amount of weight of each ingredient type you’d like to purchase. "
    "If you try it out, you’ll probably get a recipe that looks incomprehensible. "
    "For example, you may get a recipe that is exclusively flavoring grain with no solid source of fermentable sugar. "
    "You may be asked to pitch champagne yeast into a stout. "
    "These may sound disgusting, and they probably are! "
    "However, this recipe generation mode serves three purposes:"]

   [:ol
    [:li "It pushes us to reconsider what we think we know about brewing. The ingredients we do and do not pair together often come down to associations we’ve built in our mind."]
    [:li "The functionality is a building block for the more complex generation modes."]
    [:li "It’s fun to spin the wheel and see what happens."]]

   [:p
    "If you try it out, you'll probably come to the same conclusion Nick did while developing brew-bot. "
    "Without guidance, there are " [:i "a lot "] "of selections made, because coliisons are very rare. "
    "This is where the " [linked-item "/generators/limited-random" "Constrained Random"] " mode comes into play. "
    "We can now set limits on how many types of each ingredient we wish to include. "
    "Once that limit is reached, brew-bot will scale up the selected ingredients to the weight limits provided. "
    "This provides a solid foundation for the application, and the " [linked-item "/about/weighted" "more advanced recipe generation modes provided."]]])
