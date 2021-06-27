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


(defn select-fermentables
  "Select common-beer-format fermentables.
   This function may optionally be called with a strategy and an options map as such:
   `(select-fermentables)`
   `(select-fermentables :random)`
   `(select-fermentables :weighted {:count-cutoff 5})`

   The current strategies are:
   - :random   : A fully random selection of ingredients
   - :weighted : Each ingredient selection is made with a weighted probability passed to the function

   The following options are supported:
   - amount-cutoff         : The maximum weight, in kilograms, of fermentable ingredients to select. Defaults to 2.26796 kilograms (5 pounds)
   - count-cutoff          : The maximum number of unique ingredients to allow.
   - selection-weights     : A map from ingredient names to probability weights. e.g. {:amber-liquid-extract 5.0 :biscuit-malt 15.0 ...}. Only applicable for the :weighted strategy
   - default-weight        : A probability weight to fall back to for ingredients not specified in selection-weights. Only applicable for the :weighted strategy
   - include-adjuncts?     : A boolean switch to include adjuncts in the list of selectable ingredients. Defaults to true
   - include-dry-extracts? : A boolean switch to include dry extracts in the list of selectable ingredients. Defaults to true
   - include-extracts?     : A boolean switch to include extracts in the list of selectable ingredients. Defaults to true
   - include-grains?       : A boolean switch to include grains in the list of selectable ingredients. Defaults to true
   - include-sugars?       : A boolean switch to include sugars in the list of selectable ingredients. Defaults to true"
  ([]
   (select-fermentables :random))

  ([strategy]
   (select-fermentables strategy {}))

  ([strategy opts]
   (let [ingredient-options (merge {:include-adjuncts?     true
                                    :include-dry-extracts? true
                                    :include-extracts?     true
                                    :include-grains?       true
                                    :include-sugars?       true} opts)
         fermentables (ingredients/select-fermentables ingredient-options)]
     (select-ingredients fermentables strategy opts))))


(defn select-yeasts
  "Select common-beer-format yeasts.
   This function may optionally be called with a strategy and an options map as such:
   `(select-yeasts)`
   `(select-yeasts :random)`
   `(select-yeasts :weighted {:count-cutoff 5})`

   The current strategies are:
   - :random   : A fully random selection of ingredients
   - :weighted : Each ingredient selection is made with a weighted probability passed to the function

   The following options are supported:
   - amount-cutoff          : The maximum weight, in kilograms, of the yeast to select. Defaults to 2.26796 kilograms (5 pounds)
   - count-cutoff           : The maximum number of unique ingredients to allow.
   - selection-weights      : A map from ingredient names to probability weights. e.g. {:s-04-safale-english-ale 20.0 ...}. Only applicable for the :weighted strategy
   - default-weight         : A probability weight to fall back to for ingredients not specified in selection-weights. Only applicable for the :weighted strategy
   - include-brewtek?       : A boolean switch to include yeasts from Brewtek. Defaults to true
   - include-dcl-fermentis? : A boolean switch to include yeasts from DCL Fermentis. Defaults to true
   - include-lallemand?     : A boolean switch to include yeasts from Lallemand. Defaults to true
   - include-white-labs?    : A boolean switch to include yeasts from White Labs. Defaults to true
   - include-wyeast?        : A boolean switch to include yeasts from Wyeast. Defaults to true"
  ([]
   (select-yeasts :random))

  ([strategy]
   (select-yeasts strategy {}))

  ([strategy opts]
   (let [ingredient-options (merge {:include-brewtek?       true
                                    :include-dcl-fermentis? true
                                    :include-lallemand?     true
                                    :include-white-labs?    true
                                    :include-wyeast?        true} opts)
         yeasts (ingredients/select-yeasts ingredient-options)]
     (select-ingredients yeasts strategy opts))))


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
   - amount-cutoff      : The maximum weight, in kilograms, of the hops to select. Defaults to 2.26796 kilograms (5 pounds)
   - count-cutoff       : The maximum number of unique ingredients to allow.
   - selection-weights  : A map from ingredient names to probability weights. e.g. {:galaxy 20.0 ...}. Only applicable for the :weighted strategy
   - default-weight     : A probability weight to fall back to for ingredients not specified in selection-weights. Only applicable for the :weighted strategy
   - timing-strategy    : A keyword from the set #{:random :weighted :inferred} to determine how hop timings and uses should be selected. Defaults to :random
   - use-weights        : A map from hop use names to weights. e.g. {\"boil\" 60 ...}
   - time-weights       : A map from hop addition times to weights. e.g. {120 60.0 45 15.0 ...}
   - include-aroma?     : A boolean switch to include aromatic hops. Defaults to true
   - include-bittering? : A boolean switch to include bittering hops. Defaults to true
   - include-both?      : A boolean switch to include dual-purpose hops. Defaults to true"
  ([]
   (select-hops :random))

  ([strategy]
   (select-hops strategy {}))

  ([strategy opts]
   (let [ingredient-options (merge {:include-aroma?     true
                                    :include-bittering? true
                                    :include-both?      true} opts)
         hops (ingredients/select-hops ingredient-options)
         selected-hops (select-ingredients hops strategy opts)]
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
