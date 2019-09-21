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
   :max           1000000})

(def ^:const integer-number-opts
  {:default-value 5
   :step          1
   :min           0
   :max           1000000})

(def ^:const recipe-generator-section-style
  {:style {:padding-top     "18px"
           :display         "flex"
           :justify-content "flex-start"}})

(defn ingredient-checkbox-list-item
  [ingredient-type ingredient-key]
  (let [current-recipe         @(rf/subscribe [:current-recipe])
        ingredients            @(rf/subscribe [:source-ingredients])
        ingredient-probability (get-in current-recipe [ingredient-type :probabilities])
        ingredient-data        (get-in ingredients [ingredient-type ingredient-key])
        ingredient-name        (:name ingredient-data)
        id                     (str ingredient-name "-checkbox")
        alt-text               (reduce-kv (fn [acc k v] (str acc (name k) ": " v "\n")) "" ingredient-data)]
    [:li {:style {:display        "block"
                  :width          "25%"
                  :float          "left"
                  :padding-bottom "4px"}
          :title alt-text}
     ^{:key id} [:input {:id        id
                         :type      "checkbox"
                         :checked   (contains? ingredient-probability ingredient-key)
                         :style     {:cursor "pointer"}
                         :on-change #(rf/dispatch [:toggle-ingredient-selection ingredient-type ingredient-key])}]
     [:label {:for id
              :style {:cursor       "pointer"
                      :padding-left "8px"}} ingredient-name]]))

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
   [numeric-input-column "Pounds of grain"   #(rf/dispatch [:update-current-recipe [:grains :weight] %])]
   [numeric-input-column "Pounds of extract" #(rf/dispatch [:update-current-recipe [:extracts :weight] %]) {:default-value 3.0}]
   [numeric-input-column "Ounces of hops"    #(rf/dispatch [:update-current-recipe [:hops :weight] %]) {:default-value 3.0}]])

(defn recipe-generator-counts
  []
  [:div recipe-generator-section-style
   [numeric-input-column "Maximum grain types"   #(rf/dispatch [:update-current-recipe [:grains :count] %])   {:mode :integer}]
   [numeric-input-column "Maximum extract types" #(rf/dispatch [:update-current-recipe [:extracts :count] %]) {:mode :integer}]
   [numeric-input-column "Maximum hop types"     #(rf/dispatch [:update-current-recipe [:hops :count] %])     {:mode :integer}]])

(defn recipe-generator-ingredients
  []
  (let [ingredients @(rf/subscribe [:source-ingredients])]
  [:div {:style {:display "flex"
                 :flex-direction "column"}}
  [:div {:style {:padding-top "10px"}}
   [:h3 "Grains to include"]
   (into [:ul]
         (for [grain (sort (keys (:grains ingredients)))]
           ^{:key (random-uuid)} [ingredient-checkbox-list-item :grains grain]))]
  [:div {:style {:padding-top "10px"}}
   [:h3 "Extracts to include"]
   (into [:ul]
         (for [extract (sort (keys (:extracts ingredients)))]
           ^{:key (random-uuid)} [ingredient-checkbox-list-item :extracts extract]))]
  [:div {:style {:padding-top "10px"}}
   [:h3 "Hops to include"]
   (into [:ul]
         (for [hop (sort (keys (:hops ingredients)))]
           ^{:key (random-uuid)} [ingredient-checkbox-list-item :hops hop]))]
  [:div {:style {:padding-top "10px"}}
   [:h3 "Yeasts to include"]
   (into [:ul]
         (for [yeast (sort (keys (:yeasts ingredients)))]
           ^{:key (random-uuid)} [ingredient-checkbox-list-item :yeasts yeast]))]]))

(defn recipe-generator-body
  [generator-type has-changed?]
  [:div {:style {:padding-left "10px"}}
   [:h2 (if has-changed? "Recipe Generator*" "Recipe Generator")]
   [:div {:style {:padding "5px"}}
    (when (#{:random :limited-random :weighted-random :weighted-guided} generator-type)
      [recipe-generator-quantities])
    (when (#{:limited-random :weighted-random :weighted-guided} generator-type)
      [recipe-generator-counts])
    (when (#{:weighted-random :weighted-guided} generator-type)
      [recipe-generator-ingredients])
    [:div {:style {:padding-top "18px"}}
     [ant/button {:type "primary" :on-click #(rf/dispatch [:generate-recipe generator-type])} "Generate Recipe"]]]])

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
