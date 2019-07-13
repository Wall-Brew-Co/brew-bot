(ns brew-bot.core
  (:gen-class))

(def ^:const american-base-grains
  {:black-barley {:name "Black Barley"
                  :gravity 1.023
                  :notes "Imparts dryness. Unmalted - use in porters and dry stouts."}
    :black-patent-malt {:name "Black Patent Malt"
                        :gravity  1.026
                        :notes "Provides color and sharp flavor in stouts and porters."}})

(def ^:const hops
  {:ahtanum {:name "Ahtanum"
             :alpha 5.7
             :beta 5.0}})

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
  (let [ingredients (keys ingredient-set)]
    (loop [ingredient-map {}
           weight 0.0]
      (if (< weight weight-cutoff)
        (let [ingredient (rand-nth ingredients)
              ingredient-addition (rand-nth ingredient-amounts)]
          (recur (update-or-assoc ingredient-map ingredient ingredient-addition #(+ ingredient-addition %)) (+ weight ingredient-addition)))
          ingredient-map))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (generate-ingredients-and-quantities american-base-grains 5.0)))
