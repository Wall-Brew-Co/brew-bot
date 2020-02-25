(ns brew-bot.style-lists.weight-test
  (:require [brew-bot.ingredients :as bb]
            [brew-bot.style-lists.weights :as weights]
            #? (:clj  [clojure.test :refer [deftest is testing run-tests]])
            #? (:cljs [cljs.test    :refer-macros [deftest is testing run-tests]])))

(deftest marzen-validity-test
  (testing "Ensure all marzen ingredients exist and are valid"
    (is (every? #(get bb/grains-keys %)   (keys (:grains weights/marzen))))
    (is (every? #(get bb/extracts-keys %) (keys (:extracts weights/marzen))))
    (is (every? #(get bb/hops-keys %)     (keys (:hops weights/marzen))))
    (is (every? #(get bb/yeasts-keys %)   (keys (:yeasts weights/marzen))))))

(deftest imperial-stout-validity-test
  (testing "Ensure all imperial stout ingredients exist and are valid"
    (is (every? #(get bb/grains-keys %)   (keys (:grains weights/imperial-stout))))
    (is (every? #(get bb/extracts-keys %) (keys (:extracts weights/imperial-stout))))
    (is (every? #(get bb/hops-keys %)     (keys (:hops weights/imperial-stout))))
    (is (every? #(get bb/yeasts-keys %)   (keys (:yeasts weights/imperial-stout))))))
