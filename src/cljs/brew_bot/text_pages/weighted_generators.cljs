(ns brew-bot.text-pages.weighted-generators
  "Static text about the weighted recipe generators"
  (:require [brew-bot.visual-identity.colors :as colors]
            [brew-bot.visual-identity.components :as comps]))

(defn weighted-generators
  []
  [:div {:style {:max-width "50em"}}
   [:h2 "Weighted Generators"]

   [:p
    "The " [comps/linked-item "/about/random" "Random Generators" "Try out the random generator!"] " gave us a lot of the core functionality we needed to write brew-bot. "
    "Now that we have the building blocks in place, how can we use them more intelligently? "
    "Let’s think about the brewing process, and how ingredients get selected by humans. "
    "A brewer may pick a 3:1 ratio of 2-row to Caramel/Crystal malt to get an appropriate amount of sugar released for fermentation, while also picking up the lovely toffee-like flavor of the darker malt. "
    "So, it’s apparent that certain ingredients should be able to take precedence over others. "
    "In mathematics, this is commonly known as weighting."]

   [:p
    "The " [comps/linked-item "/generators/weighted-random" "Weighted Random" "Try out the weighted random generator!"] " recipe generator helps us do that. "
    "After selecting the maximum number and weights of each ingredient type, we can select specific grains, extracts, hops, and yeasts that we’d like to focus in on. "
    "These selections are then listed out below for us to weigh. "
    "The higher the weight, the more likely that ingredient is to be selected. "
    "Brew-bot will then select ingredients with a bit more caution, preferring those we’ve nudged it towards; "
    "however, it may still choose to make an addition of a random ingredient or two for diversity."]

   [:p
    "But, as brewers, we often want a higher degree of control. "
    "And this is where the " [comps/linked-item "/generators/weighted-guided" "Weighted Guided" "Try out the weighted guided generator!"] " recipe generator comes into play. "
    "It follows the exact same use case as above, except it " [:i "will not"] " pick ingredients the user hasn’t added to its available shopping list. "
    "This gives us the ability to hone in on the ingredients we care the most about, without risking the stray off-flavor."]])
