(ns brew-bot.recipe-generation.events
  (:require [brew-bot.db :as db]
            [brew-bot.generators :as generators]
            [re-frame.core :as rf]))

(rf/reg-event-db
 :update-current-recipe
 (fn [db [_ path val]]
   (-> db
     (update :current-recipe #(assoc-in % path val))
     (assoc-in [:current-recipe :has-recipe-changed?] true))))

(rf/reg-event-db
 :set-generator-type
 (fn [db [_ gen-type]]
    (assoc-in db [:current-recipe :generator] (keyword gen-type))))

(rf/reg-event-db
 :toggle-ingredient-selection
 (fn [db [_ ingredient-type ingredient-key]]
   (let [is-included? (get-in db [:current-recipe ingredient-type :probabilities ingredient-key])]
     (if is-included?
       (update-in db [:current-recipe ingredient-type :probabilities] dissoc ingredient-key)
       (update-in db [:current-recipe ingredient-type :probabilities] assoc ingredient-key 5)))))

(rf/reg-event-fx
 :generate-recipe
 (fn [{db :db} [_ generator-type]]
   (let [source (:current-recipe db)
         recipe (generators/generate-beer-recipe generator-type (:gallons source) (:grains source) (:extracts source) (:hops source) (:yeasts source))]
     {:db (assoc db :generated-recipe recipe)
      :dispatch [:update-current-page :recipe-preview]})))
