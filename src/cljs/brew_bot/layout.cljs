(ns brew-bot.layout
  (:require [antizer.reagent :as ant]
            [brew-bot.recipe-generation.views :as recipe-generator]
            [brew-bot.visual-identity :as vi]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(defn about-me
  []
  [:div
   [:h2 "About Me"]
   [:p "Welcome to brew-bot! I'm an autonomous beer recipe generator developed by "
    [:a {:href "https://github.com/nnichols" :target "_blank"} "Nick Nichols"]]])

(defn app-banner
  []
  [ant/layout-header {:class "banner"}
   (r/as-element
    [ant/row
     [ant/col {:span 12}
      [:h2 {:style {:color "white" :margin-bottom "-12px"}} "Brew Bot"]]
     [ant/col {:span 1 :offset 11}
      [:a {:href "https://github.com/nnichols/brew-bot"}
       [ant/icon {:class "banner-logo" :type "github"}]]]])])

(defn app-footer
  []
  [ant/layout-footer {:style {:background-color vi/dark-blue}}
   (r/as-element
    [ant/row {:style {:align "bottom" :text-align "center" :color vi/dim-gray}}
     [ant/col
      [:p {:style {:font-size "10pt"}} "Brew Bot"]]])])

(defn side-menu
  [has-recipe-changed?]
  [ant/menu {:mode "inline" :theme "dark"}
   [ant/menu-item {:on-click #(rf/dispatch [:update-current-page :about])} "Learn About Me"]
   [ant/menu-sub-menu {:title "Generate Recipes"}
    [ant/menu-item {:on-click #(rf/dispatch [:update-current-page :random])}          "Purely Random"]
    [ant/menu-item {:on-click #(rf/dispatch [:update-current-page :limited-random])}  "Constrained Random"]
    [ant/menu-item {:on-click #(rf/dispatch [:update-current-page :weighted-random])} "Weighted Random"]
    [ant/menu-item {:on-click #(rf/dispatch [:update-current-page :weighted-guided])} "Weighted Guided"]]])

(defn main-panel
  []
  (let [current-page (rf/subscribe [:current-page])
        has-recipe-changed? (rf/subscribe [:current-recipe])]
    (fn []
      [ant/locale-provider {:locale (ant/locales "en_US")}
       [ant/layout {:style {:min-height "100vh" :min-width "100vw"}}
        [ant/affix [app-banner]]
        [ant/layout
         [ant/layout-sider [side-menu @has-recipe-changed?]]
         [ant/layout {:style {:width "60%"}}
          [ant/layout-content {:class "content-area"}
           [ant/row {:gutter 12 :style {:padding-left "20px" :padding-top "20px"}}
            (condp = @current-page
              :about                     (about-me)
              :random                    (recipe-generator/recipe-generator-body @current-page)
              :limited-random            (recipe-generator/recipe-generator-body @current-page)
              :weighted-random           (recipe-generator/recipe-generator-body @current-page)
              :weighted-guided           (recipe-generator/recipe-generator-body @current-page)
              (about-me))]]]]
        [app-footer]]])))
