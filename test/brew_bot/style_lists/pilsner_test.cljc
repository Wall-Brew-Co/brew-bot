(ns brew-bot.style-lists.pilsner-test
  (:require [brew-bot.style-lists.pilsner :as style]
            [clojure.spec.alpha :as csa]
            [brew-bot.spec :as s]
            #? (:clj  [clojure.test :refer [deftest is testing run-tests]])
            #? (:cljs [cljs.test    :refer-macros [deftest is testing run-tests]])))

(deftest valid-bjcp-test
  (testing "Ensure all marzen ingredients exist and are valid"
    (is (csa/valid? ::s/bjcp-style style/czech-premium-pale-lager))
    (is (csa/valid? ::s/bjcp-style style/german-pils))
    (is (csa/valid? ::s/bjcp-style style/pre-prohibition-lager))))
