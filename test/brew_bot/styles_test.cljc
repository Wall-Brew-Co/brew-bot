(ns brew-bot.styles-test
  (:require [brew-bot.styles :as style]
            [clojure.spec.alpha :as csa]
            [brew-bot.spec :as s]
            #? (:clj  [clojure.test :refer [deftest is testing run-tests]])
            #? (:cljs [cljs.test    :refer-macros [deftest is testing run-tests]])))

(deftest valid-bjcp-test
  (testing "Ensure all bjcp definitions are well-formed"
    (let [bjcp-styles (vals style/beer-styles)]
      (is (every? #(csa/valid? ::s/bjcp-style %) bjcp-styles)))))
