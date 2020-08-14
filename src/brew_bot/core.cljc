(ns brew-bot.core
  "Beer recipe generators"
  (:require [brew-bot.default-values :as defaults]
            [brew-bot.selectors :as selectors]
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

(defn data->cbf-recipe
  [recipe-name recipe-type style brewer-name batch-size boil-size boil-time hops fermentables miscs yeasts waters mash]
  (let [raw-recipe {:name         recipe-name
                    :version      defaults/common-beer-format-version
                    :type         recipe-type
                    :style        style
                    :brewer       brewer-name
                    :batch-size   batch-size
                    :boil-size    boil-size
                    :boil-time    boil-time
                    :hops         hops
                    :fermentables fermentables
                    :miscs        miscs
                    :yeasts       yeasts
                    :waters       waters
                    :mash         mash}]
    (cbf/conform ::cbf-recipe/recipe raw-recipe)))
