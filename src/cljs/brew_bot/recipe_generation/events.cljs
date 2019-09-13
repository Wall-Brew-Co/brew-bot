(ns brew-bot.recipe-generation.events
  (:require [brew-bot.recipe-generation.generators :as generators]
            [brew-bot.recipe-generation.weights :as weights]
            [re-frame.core :as rf]))

(rf/reg-event-db
  :update-current-recipe
  (fn [db [_ path val]]
    (update db :current-recipe #(assoc-in % path val))))

(rf/reg-event-fx
 :generate-recipe
 (fn [{db :db} [_ generator-type]]
   (let [s (:current-recipe db)
         recipe (generators/generate-random-recipe (:gallons s) (:grain-opts s) (:extract-opts s) (:hop-opts s) (:yeast-opts s))
         marzen (generators/generate-weighted-guided-recipe 5 {:weight 5.0 :count 3 :probabilities (:grains weights/marzen)}
                                                              {:weight 3.5 :count 1 :probabilities (:extracts weights/marzen)}
                                                              {:weight 1.0 :count 4 :probabilities (:hops weights/marzen)}
                                                              {:probabilities (:yeasts weights/marzen)})
         _ (println marzen)]
   {:db (assoc db :generated-recipe marzen)
    :dispatch [:update-current-page :recipe-preview]})))
