(ns brew-bot.ingredient-lists.yeasts-test
  (:require [brew-bot.ingredient-lists.yeasts :as bby]
            #? (:clj  [clojure.test :refer [deftest is testing run-tests]])
            #? (:cljs [cljs.test    :refer-macros [deftest is testing run-tests]])))

(deftest get-available-yeasts-tests
  (testing "Ensure only applicable yeasts are returned"
    (is (empty? (bby/get-available-yeasts [])))
    (is (empty? (bby/get-available-yeasts #{:fake-company "unreal-string" 2})))
    (is (= bby/brewtek-yeasts (bby/get-available-yeasts '(:brewtek))))
    (is (= bby/lallemand-lalvin-yeasts (bby/get-available-yeasts '(:lallemand-lalvin :extra-key))))
    (is (= bby/yeasts (bby/get-available-yeasts bby/yeast-manufacturers)))))
