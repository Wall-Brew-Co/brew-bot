(ns brew-bot.recipe-generation.views
  (:require [antizer.reagent :as ant]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(defn user-form
  [display-buttons?]
  (fn [props]
    (let [form (ant/get-form)
          form-style {:label-col {:span 6}
                      :wrapper-col {:span 13}}]
        [ant/form {:layout "horizontal"}
          [ant/form-item (merge form-style {:label "Name"})
            (ant/decorate-field form "name" {:rules [{:required true}]}
              [ant/input])]
          [ant/form-item (merge form-style {:label "Email"})
            (ant/decorate-field form "email" {:rules [{:required true} {:type "email"}]}
              [ant/input])]
          (if display-buttons?
            [ant/form-item {:wrapper-col {:offset 6}}
              [ant/row
                [ant/col {:span 4}
                  [ant/button {:type "primary" :on-click #(ant/validate-fields form)}
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
