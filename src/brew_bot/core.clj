(ns brew-bot.core
  (:gen-class))

(def ^:const base-grains
  {:acid-malt {:name "Acid Malt"
               :gravity 1.027}
   :amber-malt {:name "Amber Malt"
                :gravity 1.035}
   :aromatic-malt {:name "Aromatic Malt"
                   :gravity 1.036}
   :barley-hulls {:name "Barley Hulls"
                  :gravity 1.000}
   :barley-flaked {:name "Barley, Flaked"
                   :gravity 1.032}
   :barley-raw {:name "Barley, Raw"
                :gravity 1.028}
   :barley-torrefied {:name "Barley, Torrefied"
                      :gravity 1.036}
   :biscuit-malt {:name "Biscuit Malt"
                  :gravity 1.036}
   :black-patent-malt {:name "Black (Patent) Malt"
                       :gravity 1.025}
   :black-barley-stout {:name "Black Barley (Stout)"
                        :gravity 1.025}
   :brown-malt {:name "Brown Malt"
                :gravity 1.032}
   :brumalt {:name "Brumalt"
             :gravity 1.033}
   :cara-pils-dextrine {:name "Cara-Pils/Dextrine"
                        :gravity 1.033}
   :caraamber {:name "Caraamber"
               :gravity 1.035}
   :carafoam {:name "Carafoam"
              :gravity 1.033}
   :caramel-crystal-malt-10l {:name "Caramel/Crystal Malt – 10L"
                              :gravity 1.035}
   :caramel-crystal-malt-20l {:name "Caramel/Crystal Malt – 20L"
                              :gravity 1.035}
   :caramel-crystal-malt-30l {:name "Caramel/Crystal Malt – 30L"
                              :gravity 1.035}
   :caramel-crystal-malt-40l {:name "Caramel/Crystal Malt – 40L"
                              :gravity 1.034}
   :caramel-crystal-malt-60l {:name "Caramel/Crystal Malt – 60L"
                              :gravity 1.034}
   :caramel-crystal-malt-80l {:name "Caramel/Crystal Malt – 80L"
                              :gravity 1.034}
   :caramel-crystal-malt-120l {:name "Caramel/Crystal Malt - 120L"
                                :gravity 1.033}
   :caramunich-malt {:name "Caramunich Malt"
                     :gravity 1.033}
   :carared {:name "Carared"
             :gravity 1.035}
   :caravienne-malt {:name "Caravienne Malt"
                     :gravity 1.034}
   :chocolate-malt {:name "Chocolate Malt"
                    :gravity 1.028}
   :corn-flaked {:name "Corn, Flaked"
                 :gravity 1.037}
   :grits {:name "Grits"
           :gravity 1.037}
   :melanoiden-malt {:name "Melanoiden Malt"
                     :gravity 1.037}
   :mild-malt {:name "Mild Malt"
               :gravity 1.037}
   :munich-malt {:name "Munich Malt"
                 :gravity 1.037}
   :munich-malt-10l {:name "Munich Malt – 10L"
                     :gravity 1.035}
   :munich-malt-20l {:name "Munich Malt – 20L"
                     :gravity 1.035}
   :oats-flaked {:name "Oats, Flaked"
                 :gravity 1.037}
   :oats-malted {:name "Oats, Malted"
                 :gravity 1.037}
   :pale-malt-2-row-bel {:name "Pale Malt (2 Row) Bel"
                         :gravity 1.037}
   :pale-malt-2-row-uk {:name "Pale Malt (2 Row) UK"
                        :gravity 1.036}
   :pale-malt-2-row-us {:name "Pale Malt (2 Row) US"
                        :gravity 1.036}
   :pale-malt-6-row-us {:name "Pale Malt (6 Row) US"
                        :gravity 1.035}
   :peat-smoked-malt {:name "Peat Smoked Malt"
                      :gravity 1.034}
   :pilsner-2-row-belgian {:name "Pilsner (2 Row) Belgian"
                           :gravity 1.036}
   :pilsner-2-row-german {:name "Pilsner (2 Row) German"
                          :gravity 1.037}
   :pilsner-2-row-uk {:name "Pilsner (2 Row) UK"
                      :gravity 1.036}
   :rice-hulls {:name "Rice Hulls"
                :gravity 1.000}
   :rice-flaked {:name "Rice, Flaked"
                 :gravity 1.032}
   :roasted-barley {:name "Roasted Barley"
                    :gravity 1.025}
   :rye-malt {:name "Rye Malt"
              :gravity 1.029}
   :rye-flaked {:name "Rye, Flaked"
                :gravity 1.036}
   :smoked-malt {:name "Smoked Malt"
                 :gravity 1.037}
   :special-b-malt {:name "Special B Malt"
                    :gravity 1.030}
   :special-roast {:name "Special Roast"
                   :gravity 1.033}
   :toasted-malt {:name "Toasted Malt"
                  :gravity 1.033}
   :victory-malt {:name "Victory Malt"
                  :gravity 1.034}
   :vienna-malt {:name "Vienna Malt"
                 :gravity 1.036}
   :wheat-malt-belgian {:name "Wheat Malt, Belgian"
                        :gravity 1.037}
   :wheat-malt-dark {:name "Wheat Malt, Dark"
                     :gravity 1.039}
   :wheat-malt-german {:name "Wheat Malt, German"
                       :gravity 1.039}
   :wheat-flaked {:name "Wheat, Flaked"
                  :gravity 1.035}
   :wheat-roasted {:name "Wheat, Roasted"
                   :gravity 1.025}
   :wheat-torrified {:name "Wheat, Torrified"
                     :gravity 1.036}
   :white-wheat-malt {:name "White Wheat Malt"
                      :gravity 1.040}})

(def ^:const hops
  {:ahtanum {:name "Ahtanum"
             :alpha 5.7
             :beta 5.0}
   :amarillo {:name "Amarillo"
              :alpha 11.0
              :beta 7.0}
   :apollo {:name "Apollo"
            :alpha 20.0
            :beta 8.0}
   :bravo {:name "Bravo"
           :alpha 17.5
           :beta 5.0}
   :brewers-gold-us {:name "Brewer's Gold US"
                     :alpha 10.0
                     :beta 4.5}
   :cascade {:name "Cascade"
             :alpha 7.0
             :beta 7.0}
   :centennial {:name "Centennial"
                :alpha 11.5
                :beta 4.5}
   :chelan {:name "Chelan"
            :alpha 14.5
            :beta 9.8}
   :chinook {:name "Chinook"
             :alpha 14.0
             :beta 4.0}
   :citra {:name "Citra"
           :alpha 13.0
           :beta 4.5}
   :cluster {:name "Cluster"
             :alpha 8.5
             :beta 5.5}
   :crystal {:name "Crystal"
             :alpha 5.5
             :beta 6.5}
   :ctz {:name "CTZ"
         :alpha 16.5
         :beta 5.0}
   :delta {:name "Delta"
           :alpha 7.0
           :beta 7.0}
   :el-dorado {:name "El Dorado"
               :alpha 16.0
               :beta 8.0}
   :fuggle-us {:name "Fuggle US"
               :alpha 5.5
               :beta 2.0}
   :galena {:name "Galena"
            :alpha 13.5
            :beta 8.7}
   :glacier {:name "Glacier"
             :alpha 5.5
             :beta 8.2}
   :golding-us {:name "Golding US"
                :alpha 6.0
                :beta 3.0}
   :hallertau-us {:name "Hallertau US"
                  :alpha 5.5
                  :beta 5.5}
   :horizon {:name "Horizon"
             :alpha 13.0
             :beta 8.5}
   :liberty {:name "Liberty"
             :alpha 5.0
             :beta 4.0}
   :magnum-us {:name "Magnum US"
               :alpha 14.0
               :beta 6.0}
   :millennium {:name "Milennium"
                :alpha 16.5
                :beta 5.3}
   :mosaic {:name "Mosaic"
            :alpha 13.5
            :beta 3.9}
   :mt-hood {:name "Mt. Hood"
             :alpha 7.0
             :beta 8.0}
   :newport {:name "Newport"
             :alpha 17.0
             :beta 9.1}
   :northern-brewer {:name "Northern Brewer"
                     :alpha 10.0
                     :beta 5.0}
   :nugget {:name "Nugget"
            :alpha 14.0
            :beta 5.8}
   :palisade {:name "Palisade"
              :alpha 9.5
              :beta 8.0}
   :perle-us {:name "Perle US"
              :alpha 9.5
              :beta 5.0}
   :saaz-us {:name "Saaz US"
             :alpha 4.5
             :beta 4.5}
   :santium {:name "Santium"
             :alpha 7.0
             :beta 8.0}
   :simcoe {:name "Simcoe"
            :alpha 14.0
            :beta 5.0}
   :sterling {:name "Sterling"
              :alpha 5.0
              :beta 6.0}
   :summit {:name "Summit"
            :alpha 18.0
            :beta 6.0}
   :super-galena {:name "Super Galena"
                  :alpha 16.0
                  :beta 10.0}
   :tettnang-us {:name "Tettnang US"
                 :alpha 5.0
                 :beta 4.0}
   :tillicum {:name "Tillicum"
              :alpha 14.5
              :beta 10.5}
   :ultra {:name "Ultra"
           :alpha 3.5
           :beta 4.5}
   :vanguard {:name "Vanguard"
              :alpha 6.0
              :beta 7.0}
   :warrior {:name "Warrior"
             :alpha 18.0
             :beta 5.5}
   :willamette {:name "Willamette"
                :alpha 6.0
                :beta 4.5}})

(def ^:const extract
  {:dark-malt {:name "Dark Malt Extract"
               :gravity 1.043}})

(def ^:const ingredient-amounts
  [0.25 0.5 0.75 1.0])

(def ^:const hop-times
  ["90 minutes" "60 minutes" "45 minutes" "30 minutes" "15 minutes" "10 minutes" "5 minutes" "1 minute" "Flame out" "Secondary"])

(defn update-or-assoc
  [map key val update-fn]
  (if (get map key)
    (update map key update-fn)
    (assoc map key val)))

(defn generate-ingredients-and-quantities
  [ingredient-set weight-cutoff]
  (let [ingredients (keys ingredient-set)
        ingredient (rand-nth ingredients)
        ingredient-addition (rand-nth ingredient-amounts)]
    (loop [ingredient-map {}
           weight 0.0]
      (if (< weight weight-cutoff)
        (recur (update-or-assoc ingredient-map ingredient ingredient-addition #(+ ingredient-addition %))
               (+ weight ingredient-addition))
        ingredient-map))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (generate-ingredients-and-quantities american-base-grains 5.0)))
