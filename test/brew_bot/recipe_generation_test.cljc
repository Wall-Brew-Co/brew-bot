(ns brew-bot.recipe-generation-test
  (:require [clojure.spec.alpha :as csa]
            [brew-bot.spec :as s]
            [brew-bot.generators :as bb]
            #? (:clj  [clojure.test :refer [deftest is testing]])
            #? (:cljs [cljs.test    :refer-macros [deftest is testing]])))

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
      (is (csa/valid? ::s/recipe random))
      (is (csa/valid? ::s/recipe limited-random)))))
