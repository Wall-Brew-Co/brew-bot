(ns brew-bot.core-test
  (:require #? (:clj  [clojure.test :refer [deftest is testing]])
            #? (:cljs [cljs.test    :refer-macros [deftest is testing]])
            [brew-bot.core :as sut]
            [clojure.spec.alpha :as spec]
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
      (is (every? #(spec/valid? ::fermentables/fermentable %) random-fermentables))
      (is (every? #(spec/valid? ::fermentables/fermentable %) random-fermentables-2))
      (is (every? #(spec/valid? ::hops/hop %) random-hops))
      (is (every? #(spec/valid? ::hops/hop %) random-hops-2))
      (is (every? #(spec/valid? ::yeasts/yeast %) random-yeasts))
      (is (every? #(spec/valid? ::yeasts/yeast %) random-yeasts-2)))))


(deftest integration-test
  (testing "Ensure ingredients can be selected and conformed to a common-beer-format recipe. Essentially testing the core functionality of the app"
    (let [fermentables (sut/select-fermentables)
          hops         (sut/select-hops :random {:timing-strategy :inferred :amount-cutoff 0.08})
          yeast        (sut/select-yeasts :weighted {:count-cutoff 1 :amount-cutoff 1 :default-weight 1})
          recipe       (sut/ingredients->cbf-recipe-template fermentables hops yeast)]
      (is (spec/valid? ::recipes/recipe recipe)))))
