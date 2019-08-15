(ns brew-bot.recipes
  "A data store for recipes by style generated and otherwise")

(def brew-bot-originals
  {:mk1-chaos-barley-wine {:grains {:wheat-malt-belgian {:name "Wheat Malt, Belgian" :gravity 1.037 :weight 0.75}
                                    :chocolate-malt {:name "Chocolate Malt" :gravity 1.028 :weight 0.25}
                                    :rye-malt {:name "Rye Malt" :gravity 1.029 :weight 0.5}
                                    :caramel-crystal-malt-120l {:name "Caramel/Crystal Malt - 120L" :gravity 1.033 :weight 1.0}
                                    :caramel-crystal-malt-40l {:name "Caramel/Crystal Malt - 40L" :gravity 1.034 :weight 1.25}
                                    :roasted-barley {:name "Roasted Barley" :gravity 1.025 :weight 0.5}
                                    :caramel-crystal-malt-30l {:name "Caramel/Crystal Malt - 30L" :gravity 1.035 :weight 0.75}
                                    :corn-flaked {:name "Corn Flaked" :gravity 1.037 :weight 1.0}
                                    :munich-malt-10l {:name "Munich Malt - 10L" :gravity 1.035 :weight 0.75}
                                    :pale-malt-6-row-us {:name "Pale Malt (6 Row) US" :gravity 1.035 :weight 1.75}
                                    :pilsner-2-row-uk {:name "Pilsner (2 Row) UK" :gravity 1.036 :weight 0.25}
                                    :pale-malt-2-row-us {:name "Pale Malt (2 Row) US" :gravity 1.036 :weight 1.0}
                                    :brumalt {:name "Brumalt" :gravity 1.033 :weight 0.75}
                                    :barley-torrefied {:name "Barley, Torrefied" :gravity 1.036 :weight 1.0}
                                    :acid-malt {:name "Acid Malt" :gravity 1.027 :weight 1.0}}
                           :hops {:mosaic {:name "Mosaic" :alpha 13.5 :beta 3.9 :weight 0.25}
                                  :nugget {:name "Nugget" :alpha 14.0 :beta 5.8 :weight 0.25}
                                  :willamette {:name "Willamette" :alpha 6.0 :beta 4.5 :weight 1.0}
                                  :santium {:name "Santium" :alpha 7.0 :beta 8.0 :weight 0.25}
                                  :chinook {:name "Chinook" :alpha 14.0 :beta 4.0 :weight 0.5}
                                  :vanguard {:name "Vanguard" :alpha 6.0 :beta 7.0 :weight 0.75}}
                           :yeasts {:white-labs-super-high-gravity-ale {:name "Super High Gravity Ale" :product-number "WLP099" :manufacturer "White Labs"}}
                           :gravity 1.058905}
   :mk2-semi-reasonable-ale {:grains {:munich-malt {:name Munich Malt :gravity 1.037 :weight 3.25}
                                      :caramel-crystal-malt-60l {:name "Caramel/Crystal Malt - 60L" :gravity 1.034 :weight 4.0}
                                      :rice-hulls {:name "Rice Hulls" :gravity 1.0 :weight 0.75}
                                      :caramel-crystal-malt-10l {:name "Caramel/Crystal Malt - 10L" :gravity 1.035 :weight 0.75}
                                      :barley-flaked {:name "Barley, Flaked" :gravity 1.032 :weight 3.5}}
                             :hops {:nugget {:name "Nugget" :alpha 14.0 :beta 5.8 :weight 0.25}
                                    :amarillo {:name "Amarillo" :alpha 11.0 :beta 7.0 :weight 1.0}
                                    :crystal {:name "Crystal" :alpha 5.5 :beta 6.5 :weight 1.5}
                                    :galena {:name "Galena" :alpha 13.5 :beta 8.7 :weight 0.75}}
                             :yeasts {:dcl-yeast-safale-english-ale {:name "SafAle English Ale" :product-number "S-04" :manufacturer "DCL Yeast"}}
                             :gravity 1.0552300000000001}
   :mk3-american-red-ale {:grains {:pale-malt-2-row-uk {:name "Pale Malt (2 Row) UK" :gravity 1.036 :weight 1.75}
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
