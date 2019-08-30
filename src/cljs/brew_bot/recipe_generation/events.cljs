(ns brew-bot.recipe-generation.events
  (:require [brew-bot.recipe-generation.generators :as recipe]
            [re-frame.core :as rf]))

(rf/reg-event-db
 :update-purchase-limits
 (fn [db [_ recipe-options]]
   (-> db
       (assoc-in [:current-recipe :gallons]      (:gallons recipe-options))
       (assoc-in [:current-recipe :grain-opts]   (:grain-opts recipe-options))
       (assoc-in [:current-recipe :extract-opts] (:extract-opts recipe-options))
       (assoc-in [:current-recipe :hop-opts]     (:hop-opts recipe-options))
       (assoc-in [:current-recipe :yeast-opts]   (:yeast-opts recipe-options)))))

(rf/reg-event-fx
 :generate-recipe
 (fn [{db :db} [_ generator-type]]
   (let [current-recipe (:current-recipe db)
         generated-recipe (recipe/generate-beer-recipe generator-type
                                                       (:gallons      current-recipe)
                                                       (:grain-opts   current-recipe)
                                                       (:extract-opts current-recipe)
                                                       (:hop-opts     current-recipe)
                                                       (:yeast-opts   current-recipe))]
     {:db (assoc db :generated-recipe generated-recipe)
      :dispatch [:update-current-page :completed-recipe]})))
