(ns brew-bot.core
  (:gen-class))

(def ^:const american-base-grains
  {:black-barley {:name "Black Barley"
                  :gravity 1.023
                  :notes "Imparts dryness. Unmalted - use in porters and dry stouts."}
   :black-patent-malt {:name "Black Patent Malt"
                       :gravity 1.026
                       :notes "Provides color and sharp flavor in stouts and porters."}})

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
