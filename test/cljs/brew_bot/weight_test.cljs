(ns brew-bot.weight-test
  (:require [cljs.test :refer-macros [is deftest testing]]
            [brew-bot.recipe-generation.ingredients :as bb]
            [brew-bot.recipe-generation.weights :as weights]))

(deftest marzen-validity-test
  (testing "Ensure all marzen ingredients exist and are valid"
    (is (every? #(bb/grains-keys %)   (keys (:grains weights/marzen))))
    (is (every? #(bb/extracts-keys %) (keys (:extracts weights/marzen))))
    (is (every? #(bb/hops-keys %)     (keys (:hops weights/marzen))))
    (is (every? #(bb/yeasts-keys %)   (keys (:yeasts weights/marzen))))))

(deftest imperial-stout-validity-test
  (testing "Ensure all imperial stout ingredients exist and are valid"
    (is (every? #(bb/grains-keys %)   (keys (:grains weights/imperial-stout))))
    (is (every? #(bb/extracts-keys %) (keys (:extracts weights/imperial-stout))))
    (is (every? #(bb/hops-keys %)     (keys (:hops weights/imperial-stout))))
    (is (every? #(bb/yeasts-keys %)   (keys (:yeasts weights/imperial-stout))))))
