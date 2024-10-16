(ns brew-bot.core-test
  (:require [brew-bot.core :as sut]
            [clojure.test :refer [deftest is testing]]
            [com.wallbrew.spoon.spec :as spoon.spec]
            [common-beer-data.core :as data]
            [common-beer-format.fermentables :as fermentables]
            [common-beer-format.hops :as hops]
            [common-beer-format.recipes :as recipes]
            [common-beer-format.yeasts :as yeasts]))


(deftest select-ingredients-test
  (testing "Ensure all randomly fetched ingredients are legal common-beer-format ingredients"
    (let [random-fermentables   (sut/select-ingredients data/all-fermentables)
          random-fermentables-2 (sut/select-fermentables)
          random-hops           (sut/select-ingredients data/all-hops)
          random-hops-2         (sut/select-hops)
          random-yeasts         (sut/select-ingredients data/all-yeasts)
          random-yeasts-2       (sut/select-yeasts)]
      (is (every? #(spoon.spec/test-valid? ::fermentables/fermentable %) random-fermentables))
      (is (every? #(spoon.spec/test-valid? ::fermentables/fermentable %) random-fermentables-2))
      (is (every? #(spoon.spec/test-valid? ::hops/hop %) random-hops))
      (is (every? #(spoon.spec/test-valid? ::hops/hop %) random-hops-2))
      (is (every? #(spoon.spec/test-valid? ::yeasts/yeast %) random-yeasts))
      (is (every? #(spoon.spec/test-valid? ::yeasts/yeast %) random-yeasts-2)))))


(deftest integration-test
  (testing "Ensure ingredients can be selected and conformed to a common-beer-format recipe. Essentially testing the core functionality of the app"
    (let [fermentables (sut/select-fermentables)
          hops         (sut/select-hops :random {:timing-strategy :inferred :amount-cutoff 0.08})
          yeast        (sut/select-yeasts :weighted {:count-cutoff 1 :amount-cutoff 1 :default-weight 1})
          recipe       (sut/ingredients->cbf-recipe-template fermentables hops yeast)]
      (is (spoon.spec/test-valid? ::recipes/recipe recipe)))))
