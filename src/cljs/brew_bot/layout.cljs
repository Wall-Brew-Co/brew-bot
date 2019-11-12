(ns brew-bot.layout
  (:require [antizer.reagent :as ant]
            [brew-bot.recipe-generation.views :as recipe-generator]
            [brew-bot.recipes.views :as recipes]
            [brew-bot.visual-identity :as vi]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(defn about-me
  []
  [:div {:style {:max-width "50em"}}
   [:h2 "About Me"]
   [:p "Welcome to brew-bot! I'm an autonomous beer recipe generator developed by "
    [:a {:href "https://github.com/nnichols" :target "_blank"} "Nick Nichols"]]])

(defn app-banner
  []
  [ant/layout-header {:class "banner"}
   (r/as-element
    [ant/row
     [ant/col {:span 11}
      [:h2 {:style {:color "white" :margin-bottom "-12px"}} "Brew Bot"]]
     [ant/col {:span 1 :offset 11}
      [:a {:href "https://github.com/nnichols/brew-bot" :target "_blank"}
       [ant/icon {:class "banner-logo" :type "github" :title "Visit us on GitHub"}]]]])])

(defn app-footer
  []
  [ant/layout-footer {:style {:background-color vi/dark-blue}}
   (r/as-element
    [ant/row {:style {:align "bottom" :text-align "center" :color vi/dim-gray}}
     [ant/col
      [:p {:style {:font-size "10pt"}}
       [:a {:href "https://github.com/nnichols/brew-bot/issues" :target "_blank"}
        "Found something broken? Open an issue!"]]]])])

(defn side-menu
  [has-recipe-changed?]
  [ant/menu {:mode "inline" :theme "dark"}
   [ant/menu-item {:on-click #(rf/dispatch [:navigate "/about-me"])} "Learn About Me"]
   [ant/menu-sub-menu {:title "Generate Recipes"}
    [ant/menu-item {:on-click #(rf/dispatch [:navigate "/generators/random"])}          "Purely Random"]
    [ant/menu-item {:on-click #(rf/dispatch [:navigate "/generators/limited-random"])}  "Constrained Random"]
    [ant/menu-item {:on-click #(rf/dispatch [:navigate "/generators/weighted-random"])} "Weighted Random"]
    [ant/menu-item {:on-click #(rf/dispatch [:navigate "/generators/weighted-guided"])} "Weighted Guided"]]])

(defn main-body
  [current-page has-recipe-changed?]
  (fn [current-page has-recipe-changed?]
    (let [recipe-page? (#{:random :limited-random :weighted-random :weighted-guided} current-page)]
      [ant/layout {:style {:width "60%"}}
       [ant/layout-content {:class "content-area"}
        [ant/row {:gutter 12 :style {:padding-left "20px" :padding-top "20px"}}
         (cond
           (= :about current-page)          [about-me]
           recipe-page?                     [recipe-generator/recipe-generator-body current-page has-recipe-changed?]
           (= :recipe-preview current-page) [recipes/recipe-display-page]
           :else                            [about-me])]]])))

(defn main-panel
  []
  (let [current-page (rf/subscribe [:current-page])
        has-recipe-changed? (rf/subscribe [:has-recipe-changed?])]
    (fn []
      (let [recipe-page? (#{:random :limited-random :weighted-random :weighted-guided} @current-page)]
        [ant/locale-provider {:locale (ant/locales "en_US")}
         [ant/layout {:style {:min-height "100vh" :min-width "800px"}}
          [ant/affix [app-banner]]
          [ant/layout
           [ant/layout-sider [side-menu @has-recipe-changed?]]
           [main-body @current-page @has-recipe-changed?]]
          [app-footer]]]))))
