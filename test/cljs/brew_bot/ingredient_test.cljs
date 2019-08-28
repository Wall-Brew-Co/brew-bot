(ns brew-bot.ingredient-test
  (:require [cljs.test :refer-macros [is deftest testing]]
            [clojure.spec.alpha :as csa]
            [brew-bot.recipe-generation.ingredients :as bb]
            [brew-bot.spec :as s]))

(deftest grain-validity-test
  (testing "Ensure all grain definitions are well-formatted"
    (is (every? #(csa/valid? ::s/gravity %)  (map :gravity (vals bb/grains))))
    (is (every? #(csa/valid? ::s/lovibond %) (map :lovibond (vals bb/grains))))
    (is (every? #(csa/valid? ::s/name %)     (map :name (vals bb/grains))))))

(deftest extract-validity-test
  (testing "Ensure all extract definitions are well-formatted"
    (is (every? #(csa/valid? ::s/gravity %)  (map :gravity (vals bb/extracts))))
    (is (every? #(csa/valid? ::s/lovibond %) (map :lovibond (vals bb/grains))))
    (is (every? #(csa/valid? ::s/name %)     (map :name (vals bb/extracts))))))

(deftest hop-validity-test
  (testing "Ensure all hop definitions are well-formatted"
    (is (every? #(csa/valid? ::s/alpha %) (map :alpha (vals bb/hops))))
    (is (every? #(csa/valid? ::s/beta %)  (map :beta (vals bb/hops))))
    (is (every? #(csa/valid? ::s/name %)  (map :name (vals bb/hops))))))

(deftest yeast-validity-test
  (testing "Ensure all yeast definitions are well-formatted"
    (is (every? #(csa/valid? ::s/manufacturer %)   (map :manufacturer (vals bb/yeasts))))
    (is (every? #(csa/valid? ::s/product-number %) (map :product-number (vals bb/yeasts))))
    (is (every? #(csa/valid? ::s/name %)           (map :name (vals bb/yeasts))))))

(deftest const-tests
  (testing "Ensure other constants are well-defined"
    (is (every? number? bb/ingredient-amounts))
    (is (every? number? bb/hop-times))))
