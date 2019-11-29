(ns brew-bot.recipe-generation.views
  (:require [antizer.reagent :as ant]
            [brew-bot.ingredients :as bbi]
            [clojure.string :as cs]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(def ^:const decimal-number-opts
  {:default-value 5
   :step          0.25
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

(def ^:const recipe-generator-li-style
  {:style {:display        "block"
           :width          "33%"
           :float          "left"
           :padding-bottom "4px"}})

(defn ingredient-checkbox-list-item
  [ingredient-type ingredient-key]
  (let [current-recipe (rf/subscribe [:current-recipe])]
    (fn [ingredient-type ingredient-key]
      (let [ingredient-probability (get-in @current-recipe [ingredient-type :probabilities])
            ingredient-data        (get-in bbi/ingredient-list [ingredient-type ingredient-key])
            ingredient-name        (:name ingredient-data)
            id                     (str ingredient-name "-checkbox")
            alt-text               (reduce-kv (fn [acc k v] (str acc (name k) ": " v "\n")) "" ingredient-data)]
        [:li (merge recipe-generator-li-style {:title alt-text})
         ^{:key id} [:input {:id        id
                             :type      "checkbox"
                             :checked   (contains? ingredient-probability ingredient-key)
                             :style     {:cursor "pointer"}
                             :on-change #(rf/dispatch [:toggle-ingredient-selection ingredient-type ingredient-key])}]
         [:label {:for id
                  :style {:cursor       "pointer"
                          :padding-left "8px"}} ingredient-name]]))))

(defn ingredient-probability-field
  [ingredient-type ingredient-key ingredient-probability]
  (fn [ingredient-type ingredient-key ingredient-probability]
    (let [ingredient-name (get-in bbi/ingredient-list [ingredient-type ingredient-key :name])
          update-path [ingredient-type :probabilities ingredient-key]]
      [:li recipe-generator-li-style
       [:div {:style {:vertical-align "middle" :flex-basis "20%"}}
        [:h4 ingredient-name]
        [ant/input-number (merge integer-number-opts
                                 {:value ingredient-probability
                                  :on-change #(rf/dispatch [:update-current-recipe update-path %])})]]])))

(defn numeric-input-column
  ([label event value in-opts]
   (let [number-defaults (cond
                           (= :decimal (:mode in-opts)) decimal-number-opts
                           (= :integer (:mode in-opts)) integer-number-opts)]
     [:div {:style {:vertical-align "middle" :flex-basis "20%"}}
      [:h4 label]
      [ant/input-number (merge number-defaults in-opts {:on-change event :value value})]]))

  ([label event value]
   (numeric-input-column label event value {:mode :decimal})))

(defn ingredient-type-selections
  [ingredient-type]
  (let [ingredients (sort (keys (get bbi/ingredient-list ingredient-type)))
        invisible? (rf/subscribe [:is-ingredient-type-hidden? ingredient-type])]
    [:div {:style {:padding-top "10px"}}
     [:div {:style {:display "flex"}}
      [:h3 (cs/capitalize (str (name ingredient-type) " to include"))]
      [ant/icon {:type (if @invisible? "right" "down")
                 :title (str (if @invisible? "Show " "Hide ") (name ingredient-type))
                 :on-click #(rf/dispatch [:toggle-section-display ingredient-type])
                 :style {:cursor "pointer"
                         :padding-left "8px"
                         :padding-top "6px"}}]]
     (when-not @invisible?
       (into [:ul]
             (for [ingredient ingredients]
               ^{:key (random-uuid)} [ingredient-checkbox-list-item ingredient-type ingredient])))]))

(defn recipe-generator-ingredients
  []
  (fn []
    [:div {:style {:display "flex" :flex-direction "column"}}
     [ingredient-type-selections :grains]
     [ingredient-type-selections :extracts]
     [ingredient-type-selections :hops]
     [ingredient-type-selections :yeasts]]))

(defn ingredient-weight-selection-header
  [ingredient-type]
  (fn [ingredient-type]
    [:div {:style {:display "flex"}}
     [:h3 (cs/capitalize (str (name ingredient-type) " to weight"))]
     [ant/icon {:type "info-circle"
                :title (str "Assign probability weights to your chosen " (name ingredient-type) ". "
                            "The higher the value, the more likely an ingredient is to be chosen.")
                :style {:padding-left "8px"
                        :padding-top "4px"}}]]))

(defn recipe-generator-weights
  []
  (let [current-recipe (rf/subscribe [:current-recipe])]
    (fn []
      (let [grains   (get-in @current-recipe [:grains :probabilities])
            extracts (get-in @current-recipe [:extracts :probabilities])
            hops     (get-in @current-recipe [:hops :probabilities])
            yeasts   (get-in @current-recipe [:yeasts :probabilities])]
        [:div {:style {:display "flex"
                       :flex-direction "column"}}
         (when (seq grains)
           [:div {:style {:padding-top "10px"}}
            [ingredient-weight-selection-header :grains]
            (into [:ul]
                  (for [grain (sort (keys grains))]
                    ^{:key (random-uuid)} [ingredient-probability-field :grains grain (get grains grain)]))])
         (when (seq extracts)
           [:div {:style {:padding-top "10px"}}
            [ingredient-weight-selection-header :extracts]
            (into [:ul]
                  (for [extract (sort (keys extracts))]
                    ^{:key (random-uuid)} [ingredient-probability-field :extracts extract (get extracts extract)]))])
         (when (seq hops)
           [:div {:style {:padding-top "10px"}}
            [ingredient-weight-selection-header :hops]
            (into [:ul]
                  (for [hop (sort (keys hops))]
                    ^{:key (random-uuid)} [ingredient-probability-field :hops hop (get hops hop)]))])
         (when (seq yeasts)
           [:div {:style {:padding-top "10px"}}
            [ingredient-weight-selection-header :yeasts]
            (into [:ul]
                  (for [yeast (sort (keys yeasts))]
                    ^{:key (random-uuid)} [ingredient-probability-field :yeasts yeast (get yeasts yeast)]))])]))))

(defn recipe-generator-quantities
  []
  (fn []
    (let [current-recipe (rf/subscribe [:current-recipe])]
      [:div recipe-generator-section-style
       [numeric-input-column "Gallons to brew"   #(rf/dispatch [:update-current-recipe [:gallons] %])          (get-in @current-recipe [:gallons])]
       [numeric-input-column "Pounds of grain"   #(rf/dispatch [:update-current-recipe [:grains :weight] %])   (get-in @current-recipe [:grains :weight])]
       [numeric-input-column "Pounds of extract" #(rf/dispatch [:update-current-recipe [:extracts :weight] %]) (get-in @current-recipe [:extracts :weight]) {:default-value 3.0}]
       [numeric-input-column "Ounces of hops"    #(rf/dispatch [:update-current-recipe [:hops :weight] %])     (get-in @current-recipe [:hops :weight])     {:default-value 3.0}]])))

(defn recipe-generator-counts
  []
  (fn []
    (let [current-recipe (rf/subscribe [:current-recipe])]
      [:div recipe-generator-section-style
       [numeric-input-column "Maximum grain types"   #(rf/dispatch [:update-current-recipe [:grains :count] %])   (get-in @current-recipe [:grains :count])   {:mode :integer}]
       [numeric-input-column "Maximum extract types" #(rf/dispatch [:update-current-recipe [:extracts :count] %]) (get-in @current-recipe [:extracts :count]) {:mode :integer}]
       [numeric-input-column "Maximum hop types"     #(rf/dispatch [:update-current-recipe [:hops :count] %])     (get-in @current-recipe [:hops :count])     {:mode :integer}]])))

(defn recipe-generator-body
  []
  (fn []
    (let [generator-type (rf/subscribe [:generator-type])
          has-changed?   (rf/subscribe [:has-recipe-changed?])]
      [:div {:style {:padding-left "10px"}}
       [:h2 (if @has-changed? "Recipe Generator*" "Recipe Generator")]
       [:div {:style {:padding "5px"}}
        (when (#{:random :limited-random :weighted-random :weighted-guided} @generator-type)
          [recipe-generator-quantities])
        (when (#{:limited-random :weighted-random :weighted-guided} @generator-type)
          [recipe-generator-counts])
        (when (#{:weighted-random :weighted-guided} @generator-type)
          [:div
           [recipe-generator-ingredients]
           [recipe-generator-weights]])
        [:div {:style {:padding-top "18px"}}
         [ant/button {:type "primary" :on-click #(rf/dispatch [:generate-recipe @generator-type])} "Generate Recipe"]]]])))
