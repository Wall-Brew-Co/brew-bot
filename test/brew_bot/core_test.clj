(ns brew-bot.core-test
  (:require [clojure.test :refer :all]
            [clojure.spec.alpha :as csa]
            [brew-bot.spec :as s]
            [brew-bot.core :as bb]))

(deftest generate-beer-recipe-test
  (testing "Ensure the application can generate recipes that are sane"
    (let [gallons        (* (inc (rand-int 100)) 1.0)
          g-weight       (* (inc (rand-int 100)) 1.0)
          e-weight       (* (inc (rand-int 100)) 1.0)
          h-weight       (* (inc (rand-int 100)) 1.0)
          g-count        (inc (rand-int 10))
          e-count        (inc (rand-int 10))
          h-count        (inc (rand-int 10))
          grain-limits   {:weight g-weight :count g-count}
          extract-limits {:weight e-weight :count e-count}
          hop-limits     {:weight h-weight :count h-count}
          yeast-limits   nil ;; Not yet implemented
          random         (bb/generate-beer-recipe :random gallons grain-limits extract-limits hop-limits yeast-limits)
          limited-random (bb/generate-beer-recipe :limited-random gallons grain-limits extract-limits hop-limits yeast-limits)]
      (is (= (bb/generate-beer-recipe nil nil nil nil nil nil) {:invalid-strategy "Please pick a legal recipe generation strategy"}))
      (is (every? #(csa/valid? ::s/gravity %) (map :gravity (vals (:grains random)))))
      (is (every? #(csa/valid? ::s/weight %) (map :weight (vals (:grains random)))))
      (is (every? #(csa/valid? ::s/ingredient-name %) (map :name (vals (:grains random)))))
      (is (every? #(csa/valid? ::s/gravity %) (map :gravity (vals (:extracts random)))))
      (is (every? #(csa/valid? ::s/weight %) (map :weight (vals (:extracts random)))))
      (is (every? #(csa/valid? ::s/ingredient-name %) (map :name (vals (:extracts random)))))
      (is (every? #(csa/valid? ::s/hop-acid %) (map :alpha (vals (:hops random)))))
      (is (every? #(csa/valid? ::s/hop-acid %) (map :beta (vals (:hops random)))))
      (is (every? #(csa/valid? ::s/weight %) (map :weight (vals (:hops random)))))
      (is (every? #(csa/valid? ::s/ingredient-name %) (map :name (vals (:hops random)))))
      (is (csa/valid? ::s/gravity (:original-gravity random)))
      (is (every? #(csa/valid? ::s/gravity %) (map :gravity (vals (:grains limited-random)))))
      (is (every? #(csa/valid? ::s/weight %) (map :weight (vals (:grains limited-random)))))
      (is (every? #(csa/valid? ::s/ingredient-name %) (map :name (vals (:grains limited-random)))))
      (is (every? #(csa/valid? ::s/gravity %) (map :gravity (vals (:extracts limited-random)))))
      (is (every? #(csa/valid? ::s/weight %) (map :weight (vals (:extracts limited-random)))))
      (is (every? #(csa/valid? ::s/ingredient-name %) (map :name (vals (:extracts limited-random)))))
      (is (every? #(csa/valid? ::s/hop-acid %) (map :alpha (vals (:hops limited-random)))))
      (is (every? #(csa/valid? ::s/hop-acid %) (map :beta (vals (:hops limited-random)))))
      (is (every? #(csa/valid? ::s/weight %) (map :weight (vals (:hops limited-random)))))
      (is (every? #(csa/valid? ::s/ingredient-name %) (map :name (vals (:hops limited-random)))))
      (is (csa/valid? ::s/gravity (:original-gravity limited-random))))))
