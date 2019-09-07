(ns brew-bot.recipe-generation.views
  (:require [antizer.reagent :as ant]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(def ^:const input-number-opts
  {:default-value 5
   :step          0.5
   :min           0
   :max           100})

(defn numeric-input-column
  ([label event in-opts]
   [:div {:style {:vertical-align "middle" :flex-basis "20%"}}
    [:h4 label]
    [ant/input-number (merge input-number-opts in-opts {:on-change event})]])

  ([label event]
   (numeric-input-column label event {})))

(defn recipe-generator-body
  [generator-type has-changed?]
  [:div {:style {:padding-left "10px"}}
   [:h2 (if has-changed? "Recipe Generator*" "Recipe Generator")]
   [:div {:style {:padding "5px"}}
    [:div {:style {:padding-top     "10px"
                   :display         "flex"
                   :justify-content "space-between"}}
     [numeric-input-column "Gallons to brew"   #(rf/dispatch [:update-current-recipe [:gallons] %])]
     [numeric-input-column "Pounds of grain"   #(rf/dispatch [:update-current-recipe [:grain-opts :weight] %])]
     [numeric-input-column "Pounds of extract" #(rf/dispatch [:update-current-recipe [:extract-opts :weight] %]) {:default-value 3.0}]
     [numeric-input-column "Ounces of hops"    #(rf/dispatch [:update-current-recipe [:hop-opts :weight] %]) {:default-value 3.0}]]
   [:div {:style {:padding-top     "10px"
                  :display         "flex"
                  :justify-content "space-around"}}
     [ant/button {:type "primary" :on-click #(rf/dispatch [:generate-recipe generator-type])} "Generate Recipe"]
     [ant/button {:type "danger" :on-click #(rf/dispatch [:reset-db generator-type])} "Reset"]]]])

(defn ingredient-bill
  [title ingredients]
  [:div {:style {:padding-top "10px"}}
    [:h3 title]
    [:div (str ingredients)]])

(defn recipe-display-page
  []
  (let [generated-recipe @(rf/subscribe [:generated-recipe])]
    (when generated-recipe
      (let [grains           (:grains generated-recipe)
        extracts         (:extracts generated-recipe)
        hops             (:hops generated-recipe)
        yeasts           (:yeasts generated-recipe)
        gravity          (:gravity generated-recipe)]
      [:div {:style {:padding-left "10px"}}
       [:h2 "Your Recipe"]
       [:div {:style {:padding "5px"}}
         [ingredient-bill "Grains" grains]
         [ingredient-bill "Extracts" extracts]
         [ingredient-bill "Hops" hops]
         [ingredient-bill "Yeast" yeasts]]]))))
