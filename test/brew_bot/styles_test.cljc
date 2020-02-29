(ns brew-bot.styles-test
  (:require [brew-bot.styles :as style]
            [clojure.spec.alpha :as csa]
            [brew-bot.spec :as s]
            #? (:clj  [clojure.test :refer [deftest is testing]])
            #? (:cljs [cljs.test    :refer-macros [deftest is testing]])))

(deftest valid-bjcp-test
  (testing "Ensure all bjcp definitions are well-formed"
    (let [bjcp-styles (vals style/beer-styles)]
      (is (every? #(csa/valid? ::s/bjcp-style %) bjcp-styles)))))

(deftest score-against-styles-boundary-test
  (testing "Given a recipe out of bounds of all style definitions, each recipe should score 0 adherence"
    (let [scores (style/score-against-styles {:gravity 0.9 :ibu 100 :sru-color 50 :abv 110.0})]
      (is (every? zero? (vals scores))))))
