(ns brew-bot.style-lists.light-lager-test
  (:require [brew-bot.style-lists.light-lager :as style]
            [clojure.spec.alpha :as csa]
            [brew-bot.spec :as s]
            #? (:clj  [clojure.test :refer [deftest is testing run-tests]])
            #? (:cljs [cljs.test    :refer-macros [deftest is testing run-tests]])))

(deftest valid-bjcp-test
  (testing "Ensure all marzen ingredients exist and are valid"
    (is (csa/valid? ::s/bjcp-style style/lite-american-lager))
    (is (csa/valid? ::s/bjcp-style style/standard-american-lager))
    (is (csa/valid? ::s/bjcp-style style/premium-american-lager))
    (is (csa/valid? ::s/bjcp-style style/munich-helles))
    (is (csa/valid? ::s/bjcp-style style/dortmunder-export))))
