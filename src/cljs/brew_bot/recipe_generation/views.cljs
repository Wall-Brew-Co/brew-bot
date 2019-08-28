(ns brew-bot.recipe-generation.views
  (:require [antizer.reagent :as ant]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(def input-number-opts
  {:initial-value    5
   :min              0
   :max              100
   :decimalSeparator "."})

(defn check-and-fire!
  "Check an ant form, and if it validates, fire event"
  [form event]
  (let [error-check-fn (fn [errors values]
                         (when (and (nil? errors) (some? values))
                           (rf/dispatch event)))]
    (ant/validate-fields form error-check-fn)))

(defn user-form
  [display-buttons?]
  (fn [props]
    (let [form (ant/get-form)
          form-style {:label-col {:span 6}
                      :wrapper-col {:span 13}}]
      [ant/form {:layout "horizontal"}
       [ant/form-item (merge form-style {:label "How many gallons are you brewing?"})
        (ant/decorate-field form "gallons" {:rules [{:required true}
                                                    {:type "number"}]}
                            [ant/input-number input-number-opts])]
       [ant/form-item (merge form-style {:label "How many pounds of grain are you buying?"})
        (ant/decorate-field form "grain" {:rules [{:required true}
                                                  {:type "number"}]}
                            [ant/input-number input-number-opts])]
       [ant/form-item (merge form-style {:label "How many pounds of malt extract are you buying?"})
        (ant/decorate-field form "extract" {:rules [{:required true}
                                                    {:type "number"}]}
                            [ant/input-number input-number-opts])]
       [ant/form-item (merge form-style {:label "How many ounces of hop pellets are you buying?"})
        (ant/decorate-field form "hops" {:rules [{:required true}
                                                 {:type "number"}]}
                            [ant/input-number input-number-opts])]
       (if display-buttons?
         [ant/form-item {:wrapper-col {:offset 6}}
          [ant/row
           [ant/col {:span 4}
            [ant/button {:type "primary" :on-click #(check-and-fire! form [:update-current-page :about])}
             "Submit"]]
           [ant/col {:offset 1}
            [ant/button {:on-click #(ant/reset-fields form)}
             "Reset"]]]])])))

(defn recipe-generator-body
  [generator-type]
  (let [_ (println generator-type)]
    [:div {:style {:padding-left "10px"}}
     [:h2 "Recipe Generator"]
     (ant/create-form (user-form true))]))
