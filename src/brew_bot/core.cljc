(ns brew-bot.core
  "Beer recipe generators"
  (:require [brew-bot.default-values :as defaults]
            [brew-bot.selectors :as selectors]
            [brew-bot.styles :as styles]
            [brew-bot.util :as util]
            [brewtility.calculations :as calc]
            [common-beer-format.core :as cbf]
            [common-beer-format.data.data :as ingredients]
            [common-beer-format.specs.recipes :as cbf-recipe]))

(defn select-ingredients
  ([ingredients]
   (select-ingredients ingredients :random))
  
  ([ingredients strategy]
   (select-ingredients ingredients strategy {}))
  
  ([ingredients strategy options]
    (let [selection-fn (case strategy
                         :random   selectors/select-ingredients-random
                         :weighted selectors/select-ingredients-weighted)]
      (selection-fn ingredients options))))

(def select-fermentables
  (partial select-ingredients ingredients/all-fermentables))

(def select-yeasts
  (partial select-ingredients ingredients/all-yeasts))

(defn select-hops
  ([]
   (select-hops :random))
  
  ([strategy]
   (select-hops strategy {}))
  
  ([strategy opts]
   (let [selected-hops (select-ingredients ingredients/all-hops strategy opts)]
     (selectors/select-hop-timings selected-hops opts))))

(defn ingredients->cbf-recipe-template
  [selected-fermentables selected-hops selected-yeasts]
  (let [cbf-fermentables           (util/fermentables->cbf-fermentables selected-fermentables)
        cbf-hops                   (util/hops->cbf-hops selected-hops)
        cbf-yeasts                 (util/yeasts->cbf-yeasts selected-yeasts)
        recipe-template            (merge {:fermentables cbf-fermentables
                                           :hops         cbf-hops
                                           :yeasts       cbf-yeasts}
                                          defaults/common-beer-format-recipe-defaults)
        type                       (util/determine-recipe-type selected-fermentables)
        boil-time                  (util/determine-boil-time selected-hops)
        estimated-original-gravity (calc/calculate-potential-gravity selected-fermentables (:batch-size recipe-template))
        estimated-final-gravity    (calc/calculate-potential-final-gravity selected-fermentables (:batch-size recipe-template) (:attenuation (first selected-yeasts)))
        estimated-color            (calc/calculate-srm-color selected-fermentables (:batch-size recipe-template))
        ibu                        (calc/calculate-recipe-ibus selected-hops (:batch-size recipe-template) estimated-original-gravity)
        estimated-abv              (calc/calculate-potential-abv selected-fermentables (:batch-size recipe-template) (:attenuation (first selected-yeasts)))
        style                      (styles/best-match estimated-original-gravity ibu estimated-color estimated-abv)
        cbf-recipe                 (assoc recipe-template
                                          :type      type
                                          :style     style
                                          :boil-time boil-time
                                          :est-og    (str estimated-original-gravity)
                                          :est-fg    (str estimated-final-gravity)
                                          :est-color (str estimated-color)
                                          :ibu       ibu
                                          :est-abv   estimated-abv)]
    (cbf/conform ::cbf-recipe/recipe cbf-recipe)))
