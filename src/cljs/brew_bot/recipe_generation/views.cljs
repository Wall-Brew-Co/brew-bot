(ns brew-bot.recipe-generation.views
  (:require [antizer.reagent :as ant]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(def input-number-opts
  {:initial-value    5
   :min              0
   :max              100
   :decimalSeparator "."})

(def form-style
  {:label-col {:span 6}
   :wrapper-col {:span 13}})

(defn check-and-fire!
  "Check an ant form, and if it validates, fire event"
  [form event]
  (let [error-check-fn (fn [errors values]
                         (when (and (nil? errors) (some? values))
                           (rf/dispatch event)))]
    (ant/validate-fields form error-check-fn)))

(defn numeric-form-item
  [form title label]
  [ant/form-item (merge form-style {:label label})
   (ant/decorate-field form title {:rules [{:required true} {:type "number"}]}
                       [ant/input-number input-number-opts])])

(defn random-recipe-builder
  [generator-type]
  (fn [generator-type]
    (let [form (ant/get-form)]
      [ant/form {:layout "horizontal"}
       [numeric-form-item form "gallons" "How many gallons are you brewing?"]
       [numeric-form-item form "grain"   "How many pounds of grain are you buying?"]
       [numeric-form-item form "extract" "How many pounds of malt extract are you buying?"]
       [numeric-form-item form "hops"    "How many ounces of hop pellets are you buying?"]
       [ant/form-item {:wrapper-col {:offset 6}}
        [ant/row
         [ant/col {:span 4}
          [ant/button {:type "primary" :on-click #(check-and-fire! form [:generate-recipe generator-type])} "Submit"]]
         [ant/col {:offset 1}
          [ant/button {:on-click #(ant/reset-fields form)} "Reset"]]]]])))

(defn recipe-generator-body
  [generator-type]
  [:div {:style {:padding-left "10px"}}
   [:h2 "Recipe Generator"]
     (condp = generator-type
       :random (ant/create-form (random-recipe-builder generator-type))

       [:div {:style {:padding-left "10px"}}
        [:h2 "Recipe Generator"]])])
