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
  "Select common-beer-format fermentables.
   This function may optionally be called with a strategy and an options map as such:
   `(select-fermentables)`
   `(select-fermentables :random)`
   `(select-fermentables :weighted {:count-cutoff 5})`

   The current strategies are:
   - :random   : A fully random selection of ingredients
   - :weighted : Each ingredient selection is made with a weighted probability passed to the function

   The following options are supported:
   - amount-cutoff     : The maximum weight, in kilograms, of fermentable ingredients to select. Defaults to 2.26796 kilograms (5 pounds)
   - count-cutoff      : The maximum number of unique ingredients to allow.
   - selection-weights : A map from ingredient names to probablity weights. e.g. {:amber-liquid-extract 5.0 :biscuit-malt 15.0 ...}. Only applicable for the :weighted strategy
   - default-weight    : A probability weight to fall back to for ingredients not specified in selection-weights. Only applicable for the :weighted strategy"
  (partial select-ingredients ingredients/all-fermentables))

(def select-yeasts
  "Select common-beer-format yeasts.
   This function may optionally be called with a strategy and an options map as such:
   `(select-yeasts)`
   `(select-yeasts :random)`
   `(select-yeasts :weighted {:count-cutoff 5})`

   The current strategies are:
   - :random   : A fully random selection of ingredients
   - :weighted : Each ingredient selection is made with a weighted probability passed to the function

   The following options are supported:
   - amount-cutoff     : The maximum weight, in kilograms, of the yeast to select. Defaults to 2.26796 kilograms (5 pounds)
   - count-cutoff      : The maximum number of unique ingredients to allow.
   - selection-weights : A map from ingredient names to probablity weights. e.g. {:s-04-safale-english-ale 20.0 ...}. Only applicable for the :weighted strategy
   - default-weight    : A probability weight to fall back to for ingredients not specified in selection-weights. Only applicable for the :weighted strategy"
  (partial select-ingredients ingredients/all-yeasts))

(defn select-hops
  "Select common-beer-format hops.
   This function may optionally be called with a strategy and an options map as such:
   `(select-hops)`
   `(select-hops :random)`
   `(select-hops :weighted {:count-cutoff 5 :timing-strategy :inferred})`

   The current strategies are:
   - :random   : A fully random selection of ingredients
   - :weighted : Each ingredient selection is made with a weighted probability passed to the function

   The following options are supported:
   - amount-cutoff     : The maximum weight, in kilograms, of the hops to select. Defaults to 2.26796 kilograms (5 pounds)
   - count-cutoff      : The maximum number of unique ingredients to allow.
   - selection-weights : A map from ingredient names to probablity weights. e.g. {:galaxy 20.0 ...}. Only applicable for the :weighted strategy
   - default-weight    : A probability weight to fall back to for ingredients not specified in selection-weights. Only applicable for the :weighted strategy
   - timing-strategy   : A keyword from the set #{:random :weighted :inferred} to determine how hop timings and uses should be selected. Defaults to :random
   - use-weights       : A map from hop use names to weights. e.g. {\"boil\" 60 ...}
   - time-weights      : A map from hop addition times to weights. e.g. {120 60.0 45 15.0 ...}"
  ([]
   (select-hops :random))

  ([strategy]
   (select-hops strategy {}))

  ([strategy opts]
   (let [selected-hops (select-ingredients ingredients/all-hops strategy opts)]
     (selectors/select-hop-timings selected-hops opts))))

(defn ingredients->cbf-recipe-template
  "Given a common-beer-format normalized collection of `selected-fermentables`, `selected-hops`, and `selected-yeasts`,
   return a normalized template recipe."
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
