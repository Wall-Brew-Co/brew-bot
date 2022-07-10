(ns brew-bot.core-test
  (:require [brew-bot.core :as sut]
            [clojure.spec.alpha :as csa]
            [common-beer-data.core :as data]
            [common-beer-format.fermentables :as fermentables]
            [common-beer-format.hops :as hops]
            [common-beer-format.recipes :as recipes]
            [common-beer-format.yeasts :as yeasts]
            #? (:clj  [clojure.test :refer [deftest is testing]])
            #? (:cljs [cljs.test    :refer-macros [deftest is testing]])))


(deftest select-ingredients-test
  (testing "Ensure all randomly fetched ingredients are legal common-beer-format ingredients"
    (let [random-fermentables   (sut/select-ingredients data/all-fermentables)
          random-fermentables-2 (sut/select-fermentables)
          random-hops           (sut/select-ingredients data/all-hops)
          random-hops-2         (sut/select-hops)
          random-yeasts         (sut/select-ingredients data/all-yeasts)
          random-yeasts-2       (sut/select-yeasts)]
      (is (every? #(csa/valid? ::fermentables/fermentable %) random-fermentables))
      (is (every? #(csa/valid? ::fermentables/fermentable %) random-fermentables-2))
      (is (every? #(csa/valid? ::hops/hop %) random-hops))
      (is (every? #(csa/valid? ::hops/hop %) random-hops-2))
      (is (every? #(csa/valid? ::yeasts/yeast %) random-yeasts))
      (is (every? #(csa/valid? ::yeasts/yeast %) random-yeasts-2)))))


(deftest integration-test
  (testing "Ensure ingredients can be selected and conformed to a common-beer-format recipe. Essentially testing the core functionality of the app"
    (let [fermentables (sut/select-fermentables)
          hops         (sut/select-hops :random {:timing-strategy :inferred :amount-cutoff 0.08})
          yeast        (sut/select-yeasts :weighted {:count-cutoff 1 :amount-cutoff 1 :default-weight 1})
          recipe       (sut/ingredients->cbf-recipe-template fermentables hops yeast)]
      (is (csa/valid? ::recipes/recipe recipe)))))
