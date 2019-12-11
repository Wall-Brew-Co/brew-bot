(ns brew-bot.ingredients
  "Basic ingredients needed to brew beer")

(def ^:const grains
  {:acid-malt {:name "Acid Malt"
               :gravity 1.027
               :lovibond 2.1
               :tags {:requires-mash? true}
               :suggested-max 10.0}
   :amber-malt {:name "Amber Malt"
                :gravity 1.035
                :lovibond 22.0
                :tags {:requires-mash? true}
                :suggested-max 20.0}
   :aromatic-malt {:name "Aromatic Malt"
                   :gravity 1.036
                   :lovibond 23
                   :tags {:requires-mash? true}
                   :suggested-max 10.0}
   :barley-flaked {:name "Barley, Flaked"
                   :gravity 1.032
                   :lovibond 1.7
                   :tags {:requires-mash? true}
                   :suggested-max 20.0}
   :barley-raw {:name "Barley, Raw"
                :gravity 1.028
                :lovibond 1.7
                :tags {:requires-mash? true}
                :suggested-max 15.0}
   :barley-torrefied {:name "Barley, Torrefied"
                      :gravity 1.036
                      :lovibond 1.7
                      :tags {:requires-mash? true}
                      :suggested-max 40.0}
   :biscuit-malt {:name "Biscuit Malt"
                  :gravity 1.036
                  :lovibond 25
                  :tags {}
                  :suggested-max 10.0}
   :black-patent-malt {:name "Black (Patent) Malt"
                       :gravity 1.025
                       :lovibond 500
                       :tags {}
                       :suggested-max 10.0}
   :black-barley-stout {:name "Black Barley (Stout)"
                        :gravity 1.025
                        :lovibond 500
                        :tags {}
                        :suggested-max 10.0}
   :blackprinz-malt {:name "Blackprinz Malt"
                     :gravity 1.025
                     :lovibond 500
                     :tags {}
                     :suggested-max 10.0}
   :brown-malt {:name "Brown Malt"
                :gravity 1.032
                :lovibond 65
                :tags {:requires-mash? true}
                :suggested-max 10.0}
   :brumalt {:name "Brumalt"
             :gravity 1.033
             :lovibond 23.0
             :tags {:requires-mash? true}
             :suggested-max 10.0}
   :cara-pils-dextrine {:name "Cara-Pils/Dextrine"
                        :gravity 1.033
                        :lovibond 1.5
                        :tags {}
                        :suggested-max 20.0}
   :cara-amber {:name "Cara-Amber"
                :gravity 1.035
                :lovibond 30
                :tags {}
                :suggested-max 20.0}
   :cara-foam {:name "Cara-Foam"
               :gravity 1.033
               :lovibond 2
               :tags {}
               :suggested-max 20.0}
   :cara-munich-malt {:name "Cara-Munich Malt"
                      :gravity 1.033
                      :lovibond 56
                      :tags {}
                      :suggested-max 10.0}
   :cara-red {:name "Cara-Red"
              :gravity 1.035
              :lovibond 20
              :tags {}
              :suggested-max 20.0}
   :cara-viennea-malt {:name "Cara-Vienna Malt"
                       :gravity 1.034
                       :lovibond 22
                       :tags {}
                       :suggested-max 10.0}
   :caramel-crystal-malt-10l {:name "Caramel/Crystal Malt – 10L"
                              :gravity 1.035
                              :lovibond 10
                              :tags {}
                              :suggested-max 20.0}
   :caramel-crystal-malt-20l {:name "Caramel/Crystal Malt – 20L"
                              :gravity 1.035
                              :lovibond 20
                              :tags {}
                              :suggested-max 20.0}
   :caramel-crystal-malt-30l {:name "Caramel/Crystal Malt – 30L"
                              :gravity 1.035
                              :lovibond 30
                              :tags {}
                              :suggested-max 20.0}
   :caramel-crystal-malt-40l {:name "Caramel/Crystal Malt – 40L"
                              :gravity 1.034
                              :lovibond 40
                              :tags {}
                              :suggested-max 20.0}
   :caramel-crystal-malt-60l {:name "Caramel/Crystal Malt – 60L"
                              :gravity 1.034
                              :lovibond 60
                              :tags {}
                              :suggested-max 20.0}
   :caramel-crystal-malt-80l {:name "Caramel/Crystal Malt – 80L"
                              :gravity 1.034
                              :lovibond 60
                              :tags {}
                              :suggested-max 20.0}
   :caramel-crystal-malt-90l {:name "Caramel/Crystal Malt – 90L"
                              :gravity 1.034
                              :lovibond 90
                              :tags {}
                              :suggested-max 20.0}
   :caramel-crystal-malt-120l {:name "Caramel/Crystal Malt - 120L"
                               :gravity 1.033
                               :lovibond 120
                               :tags {}
                               :suggested-max 20.0}
   :caramel-crystal-malt-140l {:name "Caramel/Crystal Malt - 140L"
                               :gravity 1.032
                               :lovibond 140
                               :tags {}
                               :suggested-max 20.0}
   :caramel-crystal-malt-160l {:name "Caramel/Crystal Malt - 160L"
                               :gravity 1.032
                               :lovibond 160
                               :tags {}
                               :suggested-max 20.0}
   :chocolate-malt {:name "Chocolate Malt"
                    :gravity 1.028
                    :lovibond 350
                    :tags {}
                    :suggested-max 10.0}
   :corn-flaked {:name "Corn (Flaked)"
                 :gravity 1.037
                 :lovibond 1
                 :tags {:requires-mash? true}
                 :suggested-max 40.0}
   :maris-otter-pale-malt {:name "Maris Otter Pale Malt"
                           :gravity 1.030
                           :lovibond 3
                           :tags {:requires-mash? true}
                           :suggested-max 100.0}
   :melanoiden-malt {:name "Melanoiden Malt"
                     :gravity 1.037
                     :lovibond 25
                     :tags {:requires-mash? true}
                     :suggested-max 15.0}
   :mild-malt {:name "Mild Malt"
               :gravity 1.037
               :lovibond 3
               :tags {:requires-mash? true}
               :suggested-max 100.0}
   :munich-malt {:name "Munich Malt"
                 :gravity 1.037
                 :lovibond 6
                 :tags {:requires-mash? true}
                 :suggested-max 80.0}
   :munich-malt-10l {:name "Munich Malt – 10L"
                     :gravity 1.035
                     :lovibond 10
                     :tags {:requires-mash? true}
                     :suggested-max 80.0}
   :munich-malt-20l {:name "Munich Malt – 20L"
                     :gravity 1.035
                     :lovibond 20
                     :tags {:requires-mash? true}
                     :suggested-max 80.0}
   :oats-flaked {:name "Oats, Flaked"
                 :gravity 1.037
                 :lovibond 1
                 :tags {:requires-mash? true}
                 :suggested-max 30.0}
   :oats-malted {:name "Oats, Malted"
                 :gravity 1.037
                 :lovibond 1
                 :tags {:requires-mash? true}
                 :suggested-max 10.0}
   :pale-malt-2-row-belgian {:name "Pale Malt (2 Row) Belgian"
                             :gravity 1.037
                             :lovibond 2
                             :tags {:requires-mash? true}
                             :suggested-max 100.0}
   :pale-malt-2-row-uk {:name "Pale Malt (2 Row) UK"
                        :gravity 1.036
                        :lovibond 2
                        :tags {:requires-mash? true}
                        :suggested-max 100.0}
   :pale-malt-2-row-us {:name "Pale Malt (2 Row) US"
                        :gravity 1.036
                        :lovibond 2
                        :tags {:requires-mash? true}
                        :suggested-max 100.0}
   :pale-malt-6-row-us {:name "Pale Malt (6 Row) US"
                        :gravity 1.035
                        :lovibond 1.8
                        :tags {:requires-mash? true}
                        :suggested-max 100.0}
   :peat-smoked-malt {:name "Peat Smoked Malt"
                      :gravity 1.034
                      :lovibond 2.8
                      :tags {:requires-mash? true}
                      :suggested-max 20.0}
   :pilsner-2-row-belgian {:name "Pilsner (2 Row) Belgian"
                           :gravity 1.036
                           :lovibond 2
                           :tags {:requires-mash? true}
                           :suggested-max 100.0}
   :pilsner-2-row-german {:name "Pilsner (2 Row) German"
                          :gravity 1.037
                          :lovibond 2
                          :tags {:requires-mash? true}
                          :suggested-max 100.0}
   :pilsner-2-row-uk {:name "Pilsner (2 Row) UK"
                      :gravity 1.036
                      :lovibond 2
                      :tags {:requires-mash? true}
                      :suggested-max 100.0}
   :rice-hulls {:name "Rice Hulls"
                :gravity 1.000
                :lovibond 2
                :tags {}
                :suggested-max 5.0}
   :rice-flaked {:name "Rice, Flaked"
                 :gravity 1.032
                 :lovibond 1
                 :tags {:requires-mash? true}
                 :suggested-max 25.0}
   :roasted-barley {:name "Roasted Barley"
                    :gravity 1.025
                    :lovibond 300
                    :tags {}
                    :suggested-max 10.0}
   :rye-malt {:name "Rye Malt"
              :gravity 1.029
              :lovibond 3.5
              :tags {:requires-mash? true}
              :suggested-max 15.0}
   :rye-flaked {:name "Rye, Flaked"
                :gravity 1.036
                :lovibond 3.5
                :tags {:requires-mash? true}
                :suggested-max 10.0}
   :smoked-malt {:name "Smoked Malt"
                 :gravity 1.037
                 :lovibond 9
                 :tags {:requires-mash? true}
                 :suggested-max 100.0}
   :special-b-malt {:name "Special B Malt"
                    :gravity 1.030
                    :lovibond 330
                    :tags {:requires-mash? true}
                    :suggested-max 10.0}
   :special-roast {:name "Special Roast"
                   :gravity 1.033
                   :lovibond 375
                   :tags {:requires-mash? true}
                   :suggested-max 10.0}
   :toasted-malt {:name "Toasted Malt"
                  :gravity 1.033
                  :lovibond 27
                  :tags {:requires-mash? true}
                  :suggested-max 10.0}
   :victory-malt {:name "Victory Malt"
                  :gravity 1.034
                  :lovibond 25
                  :tags {:requires-mash? true}
                  :suggested-max 15.0}
   :vienna-malt {:name "Vienna Malt"
                 :gravity 1.036
                 :lovibond 3.5
                 :tags {:requires-mash? true}
                 :suggested-max 90.0}
   :wheat-malt-belgian {:name "Wheat Malt, Belgian"
                        :gravity 1.037
                        :lovibond 2.3
                        :tags {:requires-mash? true}
                        :suggested-max 60.0}
   :wheat-malt-dark {:name "Wheat Malt, Dark"
                     :gravity 1.039
                     :lovibond 3
                     :tags {:requires-mash? true}
                     :suggested-max 20.0}
   :wheat-malt-german {:name "Wheat Malt, German"
                       :gravity 1.039
                       :lovibond 3
                       :tags {:requires-mash? true}
                       :suggested-max 60.0}
   :wheat-flaked {:name "Wheat, Flaked"
                  :gravity 1.035
                  :lovibond 2
                  :tags {:requires-mash? true}
                  :suggested-max 40.0}
   :wheat-roasted {:name "Wheat, Roasted"
                   :gravity 1.025
                   :lovibond 300
                   :tags {:requires-mash? true}
                   :suggested-max 10.0}
   :wheat-torrified {:name "Wheat, Torrified"
                     :gravity 1.036
                     :lovibond 1.7
                     :tags {:requires-mash? true}
                     :suggested-max 40.0}
   :white-wheat-malt {:name "White Wheat Malt"
                      :gravity 1.040
                      :lovibond 2.8
                      :tags {:requires-mash? true}
                      :suggested-max 60.0}})

(def ^:const hops
  {:ahtanum {:name "Ahtanum"
             :alpha 5.7
             :beta 5.0
             :tags {:hop-types [:aroma]}}
   :amarillo {:name "Amarillo"
              :alpha 11.0
              :beta 7.0
              :tags {:hop-types [:aroma]}}
   :apollo {:name "Apollo"
            :alpha 20.0
            :beta 8.0
            :tags {:hop-types [:bittering]}}
   :bravo {:name "Bravo"
           :alpha 17.5
           :beta 5.0
           :tags {:hop-types [:bittering]}}
   :brewers-gold-us {:name "Brewer's Gold US"
                     :alpha 10.0
                     :beta 4.5
                     :tags {:hop-types [:bittering]}}
   :cascade {:name "Cascade"
             :alpha 7.0
             :beta 7.0
             :tags {:hop-types [:aroma]}}
   :celeia {:name "Celeia"
            :alpha 5.5
            :beta 3.5
            :tags {:hop-types [:aroma :bittering]}}
   :centennial {:name "Centennial"
                :alpha 11.5
                :beta 4.5
                :tags {:hop-types [:aroma]}}
   :challenger {:name "Challenger"
                :alpha 2.1
                :beta 3.7
                :tags {:hop-types [:aroma]}}
   :chelan {:name "Chelan"
            :alpha 14.5
            :beta 9.8
            :tags {:hop-types [:bittering]}}
   :chinook {:name "Chinook"
             :alpha 14.0
             :beta 4.0
             :tags {:hop-types [:bittering]}}
   :citra {:name "Citra"
           :alpha 13.0
           :beta 4.5
           :tags {:hop-types [:aroma]}}
   :cluster {:name "Cluster"
             :alpha 8.5
             :beta 5.5
             :tags {:hop-types [:bittering]}}
   :crystal {:name "Crystal"
             :alpha 5.5
             :beta 6.5
             :tags {:hop-types [:aroma]}}
   :ctz {:name "CTZ"
         :alpha 16.5
         :beta 5.0
         :tags {:hop-types [:bittering]}}
   :delta {:name "Delta"
           :alpha 7.0
           :beta 7.0
           :tags {:hop-types [:aroma]}}
   :el-dorado {:name "El Dorado"
               :alpha 16.0
               :beta 8.0
               :tags {:hop-types [:aroma :bittering]}}
   :fuggle-us {:name "Fuggle US"
               :alpha 5.5
               :beta 2.0
               :tags {:hop-types [:aroma]}}
   :galena {:name "Galena"
            :alpha 13.5
            :beta 8.7
            :tags {:hop-types [:bittering]}}
   :glacier {:name "Glacier"
             :alpha 5.5
             :beta 8.2
             :tags {:hop-types [:aroma]}}
   :golding-us {:name "Golding US"
                :alpha 6.0
                :beta 3.0
                :tags {:hop-types [:aroma]}}
   :hallertau-us {:name "Hallertau US"
                  :alpha 5.5
                  :beta 5.5
                  :tags {:hop-types [:aroma]}}
   :horizon {:name "Horizon"
             :alpha 13.0
             :beta 8.5
             :tags {:hop-types [:aroma :bittering]}}
   :liberty {:name "Liberty"
             :alpha 5.0
             :beta 4.0
             :tags {:hop-types [:aroma]}}
   :magnum-us {:name "Magnum US"
               :alpha 14.0
               :beta 6.0
               :tags {:hop-types [:bittering]}}
   :millennium {:name "Millennium"
                :alpha 16.5
                :beta 5.3
                :tags {:hop-types [:bittering]}}
   :mosaic {:name "Mosaic"
            :alpha 13.5
            :beta 3.9
            :tags {:hop-types [:aroma]}}
   :mt-hood {:name "Mt. Hood"
             :alpha 7.0
             :beta 8.0
             :tags {:hop-types [:aroma]}}
   :newport {:name "Newport"
             :alpha 17.0
             :beta 9.1
             :tags {:hop-types [:bittering]}}
   :northdown {:name "Northdown"
               :alpha 8.5
               :beta 4.75
               :tags {:hop-types [:aroma :bittering]}}
   :northern-brewer {:name "Northern Brewer"
                     :alpha 10.0
                     :beta 5.0
                     :tags {:hop-types [:aroma :bittering]}}
   :nugget {:name "Nugget"
            :alpha 14.0
            :beta 5.8
            :tags {:hop-types [:bittering]}}
   :palisade {:name "Palisade"
              :alpha 9.5
              :beta 8.0
              :tags {:hop-types [:aroma]}}
   :perle-us {:name "Perle US"
              :alpha 9.5
              :beta 5.0
              :tags {:hop-types [:aroma :bittering]}}
   :saaz-us {:name "Saaz US"
             :alpha 4.5
             :beta 4.5
             :tags {:hop-types [:aroma]}}
   :santium {:name "Santium"
             :alpha 7.0
             :beta 8.0
             :tags {:hop-types [:aroma]}}
   :simcoe {:name "Simcoe"
            :alpha 14.0
            :beta 5.0
            :tags {:hop-types [:aroma]}}
   :spalt {:name "Spalt"
           :alpha 4.1
           :beta 4.0
           :tags {:hop-types [:aroma]}}
   :sterling {:name "Sterling"
              :alpha 5.0
              :beta 6.0
              :tags {:hop-types [:aroma]}}
   :summit {:name "Summit"
            :alpha 18.0
            :beta 6.0
            :tags {:hop-types [:bittering]}}
   :super-galena {:name "Super Galena"
                  :alpha 16.0
                  :beta 10.0
                  :tags {:hop-types [:bittering]}}
   :tettnang-us {:name "Tettnang US"
                 :alpha 5.0
                 :beta 4.0
                 :tags {:hop-types [:aroma]}}
   :tillicum {:name "Tillicum"
              :alpha 14.5
              :beta 10.5
              :tags {:hop-types [:bittering]}}
   :ultra {:name "Ultra"
           :alpha 3.5
           :beta 4.5
           :tags {:hop-types [:aroma]}}
   :vanguard {:name "Vanguard"
              :alpha 6.0
              :beta 7.0
              :tags {:hop-types [:aroma]}}
   :warrior {:name "Warrior"
             :alpha 18.0
             :beta 5.5
             :tags {:hop-types [:bittering]}}
   :willamette {:name "Willamette"
                :alpha 6.0
                :beta 4.5
                :tags {:hop-types [:aroma]}}})

(def ^:const extracts
  {:amber-dry-extract {:name "Amber Dry Extract"
                       :gravity 1.044
                       :lovibond 35
                       :suggested-max 100.0}
   :amber-liquid-extract {:name "Amber Liquid Extract"
                          :gravity 1.036
                          :lovibond 35
                          :suggested-max 100.0}
   :belgian-candi-syrup-45l {:name "Belgian Candi Syrup - 45L"
                             :gravity 1.032
                             :lovibond 45
                             :suggested-max 20.0}
   :belgian-candi-syrup-90l {:name "Belgian Candi Syrup - 90L"
                             :gravity 1.032
                             :lovibond 90
                             :suggested-max 20.0}
   :belgian-candi-syrup-180l {:name "Belgian Candi Syrup - 180L"
                              :gravity 1.032
                              :lovibond 180
                              :suggested-max 20.0}
   :dark-dry-extract {:name "Dark Dry Extract"
                      :gravity 1.044
                      :lovibond 60
                      :suggested-max 100.0}
   :dark-liquid-extract {:name "Dark Liquid Extract"
                         :gravity 1.036
                         :lovibond 60
                         :suggested-max 100.0}
   :extra-light-dry-extract {:name "Extra Light Dry Extract"
                             :gravity 1.044
                             :lovibond 6
                             :suggested-max 100.0}
   :light-dry-extract {:name "Light Dry Extract"
                       :gravity 1.044
                       :lovibond 6
                       :suggested-max 100.0}
   :pale-liquid-extract {:name "Pale Liquid Extract"
                         :gravity 1.036
                         :lovibond 3
                         :suggested-max 100.0}
   :pilsner-liquid-extract {:name "Pilsner Liquid Extract"
                            :gravity 1.036
                            :lovibond 3
                            :suggested-max 100.0}
   :rice-liquid-extract {:name "Rice Extract Syrup"
                         :gravity 1.032
                         :lovibond 8
                         :suggested-max 15.0}
   :rye-liquid-extract {:name "Rye Liquid Extract"
                        :gravity 1.036
                        :lovibond 9
                        :suggested-max 100.0}
   :wheat-dry-extract {:name "Wheat Dry Extract"
                       :gravity 1.044
                       :lovibond 12
                       :suggested-max 100.0}
   :wheat-liquid-extract {:name "Wheat Liquid Extract"
                          :gravity 1.036
                          :lovibond 12
                          :suggested-max 100.0}})

(def ^:const yeasts
  {:wyeast-labs-german-ale {:name "German Ale"
                            :product-number "1007"
                            :manufacturer "Wyeast Labs"}
   :wyeast-labs-american-wheat-ale {:name "American Wheat Ale"
                                    :product-number "1010"
                                    :manufacturer "Wyeast Labs"}
   :wyeast-labs-british-cask-ale {:name "British Cask Ale"
                                  :product-number "1026"
                                  :manufacturer "Wyeast Labs"}
   :wyeast-labs-london-ale {:name "London Ale"
                            :product-number "1028"
                            :manufacturer "Wyeast Labs"}
   :wyeast-labs-american-ale {:name "American Ale"
                              :product-number "1056"
                              :manufacturer "Wyeast Labs"}
   :wyeast-labs-irish-ale {:name "Irish Ale"
                           :product-number "1084"
                           :manufacturer "Wyeast Labs"}
   :wyeast-labs-wyeast-ale-blend {:name "Wyeast Ale Blend"
                                  :product-number "1087"
                                  :manufacturer "Wyeast Labs"}
   :wyeast-labs-british-ale {:name "British Ale"
                             :product-number "1098"
                             :manufacturer "Wyeast Labs"}
   :wyeast-labs-whitbread-ale {:name "Whitbread Ale"
                               :product-number "1099"
                               :manufacturer "Wyeast Labs"}
   :wyeast-labs-ringwood-ale {:name "Ringwood Ale"
                              :product-number "1187"
                              :manufacturer "Wyeast Labs"}
   :wyeast-labs-belgian-ale {:name "Belgian Ale"
                             :product-number "1214"
                             :manufacturer "Wyeast Labs"}
   :wyeast-labs-american-ale-ii {:name "American Ale II"
                                 :product-number "1272"
                                 :manufacturer "Wyeast Labs"}
   :wyeast-labs-thames-valley-ale {:name "Thames Valley Ale"
                                   :product-number "1275"
                                   :manufacturer "Wyeast Labs"}
   :wyeast-labs-london-ale-iii {:name "London Ale III"
                                :product-number "1318"
                                :manufacturer "Wyeast Labs"}
   :wyeast-labs-northwest-ale {:name "Northwest Ale"
                               :product-number "1332"
                               :manufacturer "Wyeast Labs"}
   :wyeast-labs-british-ale-ii {:name "British Ale II"
                                :product-number "1335"
                                :manufacturer "Wyeast Labs"}
   :wyeast-labs-european-ale {:name "European Ale"
                              :product-number "1338"
                              :manufacturer "Wyeast Labs"}
   :wyeast-labs-belgian-strong-ale {:name "Belgian Strong Ale"
                                    :product-number "1388"
                                    :manufacturer "Wyeast Labs"}
   :wyeast-labs-scottish-ale {:name "Scottish Ale"
                              :product-number "1728"
                              :manufacturer "Wyeast Labs"}
   :wyeast-labs-belgian-abbey-ii {:name "Belgian Abbey II"
                                  :product-number "1762"
                                  :manufacturer "Wyeast Labs"}
   :wyeast-labs-london-esb-ale {:name "London ESB Ale"
                                :product-number "1968"
                                :manufacturer "Wyeast Labs"}
   :wyeast-labs-budvar-lager {:name "Budvar Lager"
                              :product-number "2000"
                              :manufacturer "Wyeast Labs"}
   :wyeast-labs-urquell-lager {:name "Urquell Lager"
                               :product-number "2001"
                               :manufacturer "Wyeast Labs"}
   :wyeast-labs-pilsen-lager {:name "Pilsen Lager"
                              :product-number "2007"
                              :manufacturer "Wyeast Labs"}
   :wyeast-labs-american-lager {:name "American Lager"
                                :product-number "2035"
                                :manufacturer "Wyeast Labs"}
   :wyeast-labs-danish-lager {:name "Danish Lager"
                              :product-number "2042"
                              :manufacturer "Wyeast Labs"}
   :wyeast-labs-california-lager {:name "California Lager"
                                  :product-number "2112"
                                  :manufacturer "Wyeast Labs"}
   :wyeast-labs-bohemian-lager {:name "Bohemian Lager"
                                :product-number "2124"
                                :manufacturer "Wyeast Labs"}
   :wyeast-labs-wyeast-lager-blend {:name "Wyeast Lager Blend"
                                    :product-number "2178"
                                    :manufacturer "Wyeast Labs"}
   :wyeast-labs-bavarian-lager {:name "Bavarian Lager"
                                :product-number "2206"
                                :manufacturer "Wyeast Labs"}
   :wyeast-labs-european-lager-ii {:name "European Lager II"
                                   :product-number "2247"
                                   :manufacturer "Wyeast Labs"}
   :wyeast-labs-north-american-lager {:name "North American Lager"
                                      :product-number "2272"
                                      :manufacturer "Wyeast Labs"}
   :wyeast-labs-czech-pilsner-lager {:name "Czech Pilsner Lager"
                                     :product-number "2278"
                                     :manufacturer "Wyeast Labs"}
   :wyeast-labs-munich-lager {:name "Munich Lager"
                              :product-number "2308"
                              :manufacturer "Wyeast Labs"}
   :wyeast-labs-kolsch-yeast {:name "Kolsch Yeast"
                              :product-number "2565"
                              :manufacturer "Wyeast Labs"}
   :wyeast-labs-bavarian-wheat-yeast {:name "Bavarian Wheat Yeast"
                                      :product-number "3056"
                                      :manufacturer "Wyeast Labs"}
   :wyeast-labs-weihenstephan-weizen {:name "Weihenstephan Weizen"
                                      :product-number "3068"
                                      :manufacturer "Wyeast Labs"}
   :wyeast-labs-brettanomyces-bruxellensis {:name "Brettanomyces Bruxellensis"
                                            :product-number "3112"
                                            :manufacturer "Wyeast Labs"}
   :wyeast-labs-belgian-lambic-blend {:name "Belgian Lambic Blend"
                                      :product-number "3278"
                                      :manufacturer "Wyeast Labs"}
   :wyeast-labs-german-wheat {:name "German Wheat"
                              :product-number "3333"
                              :manufacturer "Wyeast Labs"}
   :wyeast-labs-forbidden-fruit {:name "Forbidden Fruit"
                                 :product-number "3463"
                                 :manufacturer "Wyeast Labs"}
   :wyeast-labs-belgian-ardennes {:name "Belgian Ardennes"
                                  :product-number "3522"
                                  :manufacturer "Wyeast Labs"}
   :wyeast-labs-bavarian-wheat {:name "Bavarian Wheat"
                                :product-number "3638"
                                :manufacturer "Wyeast Labs"}
   :wyeast-labs-belgian-saison {:name "Belgian Saison"
                                :product-number "3724"
                                :manufacturer "Wyeast Labs"}
   :wyeast-labs-roselare-belgian-blend {:name "Roselare Belgian Blend"
                                        :product-number "3763"
                                        :manufacturer "Wyeast Labs"}
   :wyeast-labs-trappist-high-gravity {:name "Trappist High Gravity"
                                       :product-number "3787"
                                       :manufacturer "Wyeast Labs"}
   :wyeast-labs-belgian-wheat-yeast {:name "Belgian Wheat Yeast"
                                     :product-number "3942"
                                     :manufacturer "Wyeast Labs"}
   :wyeast-labs-belgian-witbier {:name "Belgian Witbier"
                                 :product-number "3944"
                                 :manufacturer "Wyeast Labs"}
   :wyeast-labs-lactobacillus-delbrueckii {:name "Lactobacillus Delbrueckii"
                                           :product-number "4335"
                                           :manufacturer "Wyeast Labs"}
   :wyeast-labs-pediococcus-cerevisiae {:name "Pediococcus Cerevisiae"
                                        :product-number "4733"
                                        :manufacturer "Wyeast Labs"}
   :lallemand-lalvin-lalvin-71b-1122 {:name "Lalvin 71B-1122"
                                      :product-number "71B-1122"
                                      :manufacturer "Lallemand-Lalvin"}
   :brewtek-american-microbrewery-ale-1 {:name "American Microbrewery Ale 1"
                                         :product-number "CL-0010"
                                         :manufacturer "Brewtek"}
   :brewtek-american-microbrewery-ale-2 {:name "American Microbrewery Ale 2"
                                         :product-number "CL-0020"
                                         :manufacturer "Brewtek"}
   :brewtek-north-eastern-micro-ale {:name "North-Eastern Micro Ale"
                                    :product-number "CL-0060"
                                    :manufacturer "Brewtek"}
   :brewtek-british-microbrewery-ale {:name "British Microbrewery Ale"
                                      :product-number "CL-0110"
                                      :manufacturer "Brewtek"}
   :brewtek-british-pale-ale-1 {:name "British Pale Ale 1"
                                :product-number "CL-0120"
                                :manufacturer "Brewtek"}
   :brewtek-british-pale-ale-2 {:name "British Pale Ale 2"
                                :product-number "CL-0130"
                                :manufacturer "Brewtek"}
   :brewtek-british-real-ale {:name "British Real Ale"
                              :product-number "CL-0150"
                              :manufacturer "Brewtek"}
   :brewtek-british-draft-ale {:name "British Draft Ale"
                               :product-number "CL-0160"
                               :manufacturer "Brewtek"}
   :brewtek-classic-british-ale {:name "Classic British Ale"
                                 :product-number "CL-0170"
                                 :manufacturer "Brewtek"}
   :brewtek-irish-dry-stout {:name "Irish Dry Stout"
                             :product-number "CL-0240"
                             :manufacturer "Brewtek"}
   :brewtek-canadian-ale {:name "Canadian Ale"
                          :product-number "CL-0260"
                          :manufacturer "Brewtek"}
   :brewtek-belgian-ale-1 {:name "Belgian Ale 1"
                           :product-number "CL-0300"
                           :manufacturer "Brewtek"}
   :brewtek-belgian-ale-2 {:name "Belgian Ale 2"
                           :product-number "CL-0320"
                           :manufacturer "Brewtek"}
   :brewtek-belgian-ale-3 {:name "Belgian Ale 3"
                           :product-number "CL-0340"
                           :manufacturer "Brewtek"}
   :brewtek-saison {:name "Saison"
                    :product-number "CL-0380"
                    :manufacturer "Brewtek"}
   :brewtek-kolsch {:name "Kolsch"
                    :product-number "CL-0400"
                    :manufacturer "Brewtek"}
   :brewtek-old-german-ale {:name "Old German Ale"
                            :product-number "CL-0400"
                            :manufacturer "Brewtek"}
   :brewtek-original-pilsner {:name "Original Pilsner"
                              :product-number "CL-0600"
                              :manufacturer "Brewtek"}
   :brewtek-american-megabrewery {:name "American Megabrewery"
                                  :product-number "CL-0620"
                                  :manufacturer "Brewtek"}
   :brewtek-american-microbrewery-lager {:name "American Microbrewery Lager"
                                         :product-number "CL-0630"
                                         :manufacturer "Brewtek"}
   :brewtek-old-bavarian-lager {:name "Old Bavarian Lager"
                                :product-number "CL-0650"
                                :manufacturer "Brewtek"}
   :brewtek-northern-german-lager {:name "Northern German Lager"
                                   :product-number "CL-0660"
                                   :manufacturer "Brewtek"}
   :brewtek-east-european-lager {:name "East European Lager"
                                 :product-number "CL-0680"
                                 :manufacturer "Brewtek"}
   :brewtek-california-esteem {:name "California Esteem"
                               :product-number "CL-0690"
                               :manufacturer "Brewtek"}
   :brewtek-belgian-wheat {:name "Belgian Wheat"
                           :product-number "CL-0900"
                           :manufacturer "Brewtek"}
   :brewtek-german-weiss {:name "German Weiss"
                          :product-number "CL-0930"
                          :manufacturer "Brewtek"}
   :brewtek-american-white-ale {:name "American White Ale"
                                :product-number "CL-0980"
                                :manufacturer "Brewtek"}
   :brewtek-brettanomyces-lambicus {:name "Brettanomyces Lambicus"
                                    :product-number "CL-5200"
                                    :manufacturer "Brewtek"}
   :brewtek-pediococcus-damnosus {:name "Pediococcus Damnosus"
                                  :product-number "CL-5600"
                                  :manufacturer "Brewtek"}
   :lallemand-lalvin-lalvin-d-47 {:name "Lalvin D-47"
                                  :product-number "D-47"
                                  :manufacturer "Lallemand-Lalvin"}
   :lallemand-lalvin-lalvin-ec-1118 {:name "Lalvin EC-1118"
                                     :product-number "EC-1118"
                                     :manufacturer "Lallemand-Lalvin"}
   :dcl-yeast-safale-german-ale {:name "SafAle German Ale"
                                 :product-number "K-97"
                                 :manufacturer "DCL Yeast"}
   :dcl-yeast-safale-american-ale {:name "SafAle American Ale"
                                   :product-number "US-05"
                                   :manufacturer "DCL Yeast"}
   :lallemand-lalvin-lalvin--k1v-1116 {:name "Lalvin - K1V-1116"
                                       :product-number "K1V-1116"
                                       :manufacturer "Lallemand-Lalvin"}
   :lallemand-lalvin-lalvin-rc-212-bourgovin- {:name "Lalvin RC 212 Bourgovin "
                                               :product-number "RC 212"
                                               :manufacturer "Lallemand-Lalvin"}
   :dcl-yeast-safale-english-ale {:name "SafAle English Ale"
                                  :product-number "S-04"
                                  :manufacturer "DCL Yeast"}
   :dcl-yeast-saflager-german-lager {:name "SafLager German Lager"
                                     :product-number "S-189"
                                     :manufacturer "DCL Yeast"}
   :dcl-yeast-saflager-west-european-lager {:name "SafLager West European Lager"
                                            :product-number "S-23"
                                            :manufacturer "DCL Yeast"}
   :dcl-yeast-safbrew-ale {:name "SafBrew Ale"
                           :product-number "S-33"
                           :manufacturer "DCL Yeast"}
   :dcl-yeast-safbrew-specialty-ale {:name "SafBrew Specialty Ale"
                                     :product-number "T-58"
                                     :manufacturer "DCL Yeast"}
   :white-labs-california-ale {:name "California Ale"
                               :product-number "WLP001"
                               :manufacturer "White Labs"}
   :white-labs-english-ale {:name "English Ale"
                            :product-number "WLP002"
                            :manufacturer "White Labs"}
   :white-labs-german-ale-ii {:name "German Ale II"
                              :product-number "WLP003"
                              :manufacturer "White Labs"}
   :white-labs-irish-ale {:name "Irish Ale"
                          :product-number "WLP004"
                          :manufacturer "White Labs"}
   :white-labs-british-ale {:name "British Ale"
                            :product-number "WLP005"
                            :manufacturer "White Labs"}
   :white-labs-bedford-british-ale {:name "Bedford British Ale"
                                    :product-number "WLP006"
                                    :manufacturer "White Labs"}
   :white-labs-dry-english-ale {:name "Dry English Ale"
                                :product-number "WLP007"
                                :manufacturer "White Labs"}
   :white-labs-east-coast-ale {:name "East Coast Ale"
                               :product-number "WLP008"
                               :manufacturer "White Labs"}
   :white-labs-australian-ale-yeast {:name "Australian Ale Yeast"
                                     :product-number "WLP009"
                                     :manufacturer "White Labs"}
   :white-labs-essex-ale-yeast {:name "Essex Ale Yeast"
                                :product-number "WLP022"
                                :manufacturer "White Labs"}
   :white-labs-burton-ale {:name "Burton Ale"
                           :product-number "WLP023"
                           :manufacturer "White Labs"}
   :white-labs-southwold-ale {:name "Southwold Ale"
                              :product-number "WLP025"
                              :manufacturer "White Labs"}
   :white-labs-premium-bitter-ale {:name "Premium Bitter Ale"
                                   :product-number "WLP026"
                                   :manufacturer "White Labs"}
   :white-labs-edinburgh-ale {:name "Edinburgh Ale"
                              :product-number "WLP028"
                              :manufacturer "White Labs"}
   :white-labs-german-ale-kolsch {:name "German Ale Kolsch"
                                  :product-number "WLP029"
                                  :manufacturer "White Labs"}
   :white-labs-klassic-ale-yeast {:name "Klassic Ale Yeast"
                                  :product-number "WLP033"
                                  :manufacturer "White Labs"}
   :white-labs-dusseldorf-alt-yeast {:name "Dusseldorf Alt Yeast"
                                     :product-number "WLP036"
                                     :manufacturer "White Labs"}
   :white-labs-nottingham-ale-yeast {:name "Nottingham Ale Yeast"
                                     :product-number "WLP039"
                                     :manufacturer "White Labs"}
   :white-labs-pacific-ale {:name "Pacific Ale"
                            :product-number "WLP041"
                            :manufacturer "White Labs"}
   :white-labs-california-ale-v {:name "California Ale V"
                                 :product-number "WLP051"
                                 :manufacturer "White Labs"}
   :white-labs-super-high-gravity-ale {:name "Super High Gravity Ale"
                                       :product-number "WLP099"
                                       :manufacturer "White Labs"}
   :white-labs-hefeweizen-ale {:name "Hefeweizen Ale"
                               :product-number "WLP300"
                               :manufacturer "White Labs"}
   :white-labs-american-hefeweizen-ale {:name "American Hefeweizen Ale"
                                        :product-number "WLP320"
                                        :manufacturer "White Labs"}
   :white-labs-bavarian-weizen-yeast {:name "Bavarian Weizen Yeast"
                                      :product-number "WLP351"
                                      :manufacturer "White Labs"}
   :white-labs-hefeweizen-iv-ale {:name "Hefeweizen IV Ale"
                                  :product-number "WLP380"
                                  :manufacturer "White Labs"}
   :white-labs-belgian-wit-ale {:name "Belgian Wit Ale"
                                :product-number "WLP400"
                                :manufacturer "White Labs"}
   :white-labs-belgian-wit-ii {:name "Belgian Wit II"
                               :product-number "WLP410"
                               :manufacturer "White Labs"}
   :white-labs-trappist-ale {:name "Trappist Ale"
                             :product-number "WLP500"
                             :manufacturer "White Labs"}
   :white-labs-bastogne-belgian-ale {:name "Bastogne Belgian Ale"
                                     :product-number "WLP510"
                                     :manufacturer "White Labs"}
   :white-labs-abbey-ale {:name "Abbey Ale"
                          :product-number "WLP530"
                          :manufacturer "White Labs"}
   :white-labs-belgian-saison-i-ale {:name "Belgian Saison I Ale"
                                     :product-number "WLP565"
                                     :manufacturer "White Labs"}
   :white-labs-belgian-golden-ale {:name "Belgian Golden Ale"
                                   :product-number "WLP570"
                                   :manufacturer "White Labs"}
   :white-labs-belgian-style-ale-yeast-blend {:name "Belgian Style Ale Yeast Blend"
                                              :product-number "WLP575"
                                              :manufacturer "White Labs"}
   :white-labs-champagne-yeast {:name "Champagne Yeast"
                                :product-number "WLP715"
                                :manufacturer "White Labs"}
   :white-labs-sweet-mead-wine {:name "Sweet Mead Wine"
                                :product-number "WLP720"
                                :manufacturer "White Labs"}
   :white-labs-steinberg-geisenheim-wine {:name "Steinberg-Geisenheim Wine"
                                          :product-number "WLP727"
                                          :manufacturer "White Labs"}
   :white-labs-english-cider-yeast {:name "English Cider Yeast"
                                    :product-number "WLP775"
                                    :manufacturer "White Labs"}
   :white-labs-pilsner-lager {:name "Pilsner Lager"
                              :product-number "WLP800"
                              :manufacturer "White Labs"}
   :white-labs-czech-budejovice-lager {:name "Czech Budejovice Lager"
                                       :product-number "WLP802"
                                       :manufacturer "White Labs"}
   :white-labs-san-francisco-lager {:name "San Francisco Lager"
                                    :product-number "WLP810"
                                    :manufacturer "White Labs"}
   :white-labs-octoberfest-marzen-lager {:name "Octoberfest Marzen Lager"
                                         :product-number "WLP820"
                                         :manufacturer "White Labs"}
   :white-labs-german-lager {:name "German Lager"
                             :product-number "WLP830"
                             :manufacturer "White Labs"}
   :white-labs-german-bock-lager {:name "German Bock Lager"
                                  :product-number "WLP833"
                                  :manufacturer "White Labs"}
   :white-labs-southern-german-lager {:name "Southern German Lager"
                                      :product-number "WLP838"
                                      :manufacturer "White Labs"}
   :white-labs-cry-havoc {:name "Cry Havoc"
                          :product-number "WLP862"
                          :manufacturer "White Labs"}
   :white-labs-zurich-lager {:name "Zurich Lager"
                             :product-number "WLP885"
                             :manufacturer "White Labs"}
   :white-labs-mexican-lager {:name "Mexican Lager"
                              :product-number "WLP940"
                              :manufacturer "White Labs"}})

(def ^:const grains-keys
  (set (keys grains)))

(def ^:const hops-keys
  (set (keys hops)))

(def ^:const extracts-keys
  (set (keys extracts)))

(def ^:const yeasts-keys
  (set (keys yeasts)))

(def ^:const ingredient-amounts
  [0.25 0.5 0.75 1.0])

(def ^:const hop-times
  [120 90 60 45 30 15 10 5 1])

(def ingredient-list
  {:grains   grains
   :extracts extracts
   :hops     hops
   :yeasts   yeasts})
