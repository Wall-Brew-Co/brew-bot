(ns brew-bot.recipe-generation.events
  (:require [brew-bot.recipe-generation.generators :as generators]
            [brew-bot.recipe-generation.weights :as weights]
            [re-frame.core :as rf]))

(rf/reg-event-db
  :update-current-recipe
  (fn [db [_ path val]]
    (update db :current-recipe #(assoc-in % path val))))

(rf/reg-event-db
  :toggle-ingredient-selection
  (fn [db [_ ingredient-type ingredient-key]]
    (let [is-included? (get-in db [:current-recipe ingredient-type :probabilities ingredient-key])]
      (if is-included?
        (update-in db [:current-recipe ingredient-type :probabilities] dissoc ingredient-key)
        (update-in db [:current-recipe ingredient-type :probabilities] assoc ingredient-key 1)))))

(rf/reg-event-fx
 :generate-recipe
 (fn [{db :db} [_ generator-type]]
   (let [s (:current-recipe db)
         recipe (generators/generate-random-recipe (:gallons s) (:grains s) (:extracts s) (:hops s) (:yeasts s))]
   {:db (assoc db :generated-recipe recipe)
    :dispatch [:update-current-page :recipe-preview]})))
