(ns brew-bot.recipe-generation.views
  (:require [antizer.reagent :as ant]
            [brew-bot.util :as util]
            [brew-bot.visual-identity :as vis]
            [cljs.pprint :as pprint]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(def ^:const decimal-number-opts
  {:default-value 5
   :step          0.5
   :min           0
   :max           100})

(def ^:const integer-number-opts
  {:default-value 5
   :step          1
   :min           0
   :max           10})

(def ^:const recipe-generator-section-style
  {:style {:padding-top     "10px"
           :display         "flex"
           :justify-content "space-between"}})

(defn numeric-input-column
  ([label event in-opts]
   (let [numeric-mode (or (:mode in-opts) :decimal)
         number-defaults (cond
                           (= :decimal numeric-mode) decimal-number-opts
                           (= :integer numeric-mode) integer-number-opts)]
   [:div {:style {:vertical-align "middle" :flex-basis "20%"}}
    [:h4 label]
    [ant/input-number (merge number-defaults in-opts {:on-change event})]]))

  ([label event]
   (numeric-input-column label event {})))

(defn recipe-generator-quantities
  []
  [:div recipe-generator-section-style
   [numeric-input-column "Gallons to brew"   #(rf/dispatch [:update-current-recipe [:gallons] %])]
   [numeric-input-column "Pounds of grain"   #(rf/dispatch [:update-current-recipe [:grain-opts :weight] %])]
   [numeric-input-column "Pounds of extract" #(rf/dispatch [:update-current-recipe [:extract-opts :weight] %]) {:default-value 3.0}]
   [numeric-input-column "Ounces of hops"    #(rf/dispatch [:update-current-recipe [:hop-opts :weight] %]) {:default-value 3.0}]])

(defn recipe-generator-counts
  []
  [:div recipe-generator-section-style
   [numeric-input-column "Maximum grain types"   #(rf/dispatch [:update-current-recipe [:grain-opts :count] %])   {:mode :integer}]
   [numeric-input-column "Maximum extract types" #(rf/dispatch [:update-current-recipe [:extract-opts :count] %]) {:mode :integer}]
   [numeric-input-column "Maximum hop types"     #(rf/dispatch [:update-current-recipe [:hop-opts :count] %])     {:mode :integer}]])

(defn recipe-generator-body
  [generator-type has-changed?]
  [:div {:style {:padding-left "10px"}}
   [:h2 (if has-changed? "Recipe Generator*" "Recipe Generator")]
   [:div {:style {:padding "5px"}}
    (when (#{:random :limited-random :weighted-random :weighted-guided} generator-type)
      [recipe-generator-quantities])
    (when (#{:limited-random :weighted-random :weighted-guided} generator-type)
      [recipe-generator-counts])
    [:div {:style {:padding-top     "10px"
                   :display         "flex"
                   :justify-content "space-around"}}
     [ant/button {:type "primary" :on-click #(rf/dispatch [:generate-recipe generator-type])} "Generate Recipe"]
     [ant/button {:type "danger" :on-click #(rf/dispatch [:reset-db generator-type])} "Reset"]]]])

(defn ingredient-bill
  [title type ingredients]
  [:div {:style {:padding-top "10px"}}
   [:h3 title]
   (into [:ul]
         (for [ingredient (vals (sort-by :weight ingredients))
               :let [display-name (:name ingredient)
                     weight       (:weight ingredient)
                     weight-unit  (util/pluralize weight (if (= type :hops) "ounce" "pound"))]]
           ^{:key ingredient} [:li (str display-name " - " weight " " weight-unit)]))])

(defn recipe-display-page
  []
  (let [generated-recipe @(rf/subscribe [:generated-recipe])]
    (when generated-recipe
      (let [grains           (:grains generated-recipe)
            extracts         (:extracts generated-recipe)
            hops             (:hops generated-recipe)
            yeasts           (:yeasts generated-recipe)
            gravity          (:gravity generated-recipe)
            color            (:sru-color generated-recipe)]
        [:div {:style {:padding-left "10px"}}
         [:h2 "Your Recipe"]
         [:p "Projections"]
         [:ul {:style {:max-width "200px"
                       :border (str "5px solid " (vis/srm-color-to-hex color))}}
          [:li (str "OG: "  (pprint/cl-format false  "~,3f" (:gravity generated-recipe)))]
          [:li (str "ABV: " (pprint/cl-format false  "~,2f" (:abv generated-recipe)) "%")]
          [:li (str "SRM Color: " (int color))]]
         [:div {:style {:padding-left "5px"}}
          [ingredient-bill "Grains" :grains grains]
          (when-not (empty? extracts) [ingredient-bill "Extracts" :extracts extracts])
          [ingredient-bill "Hops" :hops hops]
          [:div {:style {:padding-top "10px"}}
           [:h3 "Yeast"]
           [:ul
            [:li (:name (first (vals yeasts)))]]]]]))))
