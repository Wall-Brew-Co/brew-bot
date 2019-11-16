(ns brew-bot.text-pages.about-me
  "Static text displayed on the About Me Page")

(defn about-me
  []
  [:div {:style {:max-width "50em"}}
   [:h2 "About Me"]
   [:p
    "Welcome to brew-bot!"
    "I was originally built as an experiment for the Wall Brewing Company, and you can find the recipes I've built on "
    [:a {:href "https://wallbrew.com/category/brew-bot/" :target "_blank"} "their blog. "]
    "At its core, beer is comprised of 4-5 primary ingredients: grain, hops, yeast, water, and possibly malt extract. "
    "Recipes are collections of these various ingredients, usually put together with a purpose. "
    "For example, a brewer may pick a 3:1 ratio of 2-row to Caramel/Crystal malt to get an appropriate amount of sugar released for fermentation, while also picking up the lovely toffee-like flavor of the darker malt. "
    "Likewise, hops are chosen for the wide array of flavors they can provide: ranging from pine to citrus, all on a wide spectrum of bitterness."]

   [:p
    "Conventional wisdom and zymurgy, the branch of science concerned with fermentation, have guided the selection of ingredients for years. "
    "However, recent advances in data science have changed the game, and recipes are often adjusted by computer to account for crop variations. "
    "Brewing technology has greatly democratized the study of chemistry, and kits and chemicals are available to homebrewers to control even the finest details of their water. "
    "Brew-bot pushes this line further, and generates recipes of its own."]

   [:h3 "About Nick"]

   [:p  [:a {:href "https://github.com/nnichols" :target "_blank"} "Nick Nichols "]
    "is a clojure developer primarily interested in metaheuristics, and making the world a better place through chaos. "
    "If you'd like to learn more about him, you can follow him on social media or on his personal site: "]

   [:ul
    [:li [:a {:href "https://github.com/nnichols" :target "_blank"} "GitHub"]]
    [:li [:a {:href "https://nnichols.github.io/" :target "_blank"} "Personal Site"]]
    [:li [:a {:href "https://www.instagram.com/nickanichols/" :target "_blank"} "Instagram"]]
    [:li [:a {:href "https://twitter.com/Brainlessmunkey" :target "_blank"} "Twitter"]]
    [:li [:a {:href "https://wallbrew.com/author/nickanichols/" :target "_blank"} "WordPress"]]]])
