(ns brew-bot.recipes
  "A data store for recipes by style, generated and otherwise")

(def brew-bot-originals
  {:mk3-american-red-ale {:grains {:pale-malt-2-row-uk {:name "Pale Malt (2 Row) UK" :gravity 1.036 :weight 1.75}
                                   :caramel-crystal-malt-60l {:name "Caramel/Crystal Malt – 60L" :gravity 1.034 :weight 0.75}
                                   :caramel-crystal-malt-40l {:name "Caramel/Crystal Malt – 40L" :gravity 1.034 :weight 1.0}
                                   :pale-malt-2-row-us {:name "Pale Malt (2 Row) US" :gravity 1.036 :weight 1.75}}
                          :extracts {:light-dry-extract {:name "Light Dry Extract" :gravity 1.044 :weight 2.75}
                                     :amber-liquid-extract {:name "Amber Liquid Extract" :gravity 1.036 :weight 0.75}}
                          :hops {:willamette {:name "Willamette" :alpha 6.0 :beta 4.5 :weight 0.25}
                                 :liberty {:name "Liberty" :alpha 5.0 :beta 4.0 :weight 1.25}
                                 :magnum-us {:name "Magnum US" :alpha 14.0 :beta 6.0 :weight 0.75}
                                 :cascade {:name "Cascade" :alpha 7.0 :beta 7.0 :weight 0.75}}
                          :yeast {:wyeast-labs-european-ale {:name "European Ale" :product-number "1338" :manufacturer "Wyeast Labs"}}
                          :original-gravity 1.05557}})
