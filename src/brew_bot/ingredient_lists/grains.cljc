(ns brew-bot.ingredient-lists.grains
  "Ingredient data for various toasted barleys and common brewing grains")

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
