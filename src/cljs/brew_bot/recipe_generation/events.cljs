(ns brew-bot.recipe-generation.events
  (:require [brew-bot.recipe-generation.generators :as generators]
            [re-frame.core :as rf]))

(rf/reg-event-db
  :update-current-recipe
  (fn [db [_ path val]]
    (update db :current-recipe #(assoc-in % path val))))

(rf/reg-event-fx
 :generate-recipe
 (fn [{db :db} [_ generator-type]]
   (let [s (:current-recipe db)
         recipe (generators/generate-random-recipe (:gallons s) (:grain-opts s) (:extract-opts s) (:hop-limits s))
         _ (println recipe)]
   {:db (assoc db :generated-recipe recipe)
    :dispatch [:update-current-page :recipe-preview]})))
