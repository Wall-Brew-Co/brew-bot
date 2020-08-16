(ns brew-bot.util-test
  (:require [brew-bot.util :as sut]
            [clojure.spec.alpha :as csa]
            [common-beer-format.data.data :as data]
            [common-beer-format.specs.fermentables :as fermentables]
            [common-beer-format.specs.hops :as hops]
            [common-beer-format.specs.yeasts :as yeasts]
            [nnichols.util :as nu]
            #? (:clj  [clojure.test :refer [deftest is testing]])
            #? (:cljs [cljs.test    :refer-macros [deftest is testing]])))

(deftest min-max-kv-test
  (testing "Ensure maps can be appropiately sorted by value"
    (let [test-map {:a 3 :b 1 :c 2}]
      (is (= test-map (sut/max-n-kv test-map 3)))
      (is (= test-map (sut/max-n-kv test-map 3)))
      (is (= {:a 3 :c 2} (sut/max-n-kv test-map 2)))
      (is (= {:b 1 :c 2} (sut/min-n-kv test-map 2))))))

(deftest transformer-tests
  (testing "Ensure all common-beer-format transformers create valid wrappers"
    (is (csa/valid? ::fermentables/fermentables (sut/fermentables->cbf-fermentables (take 10 (repeatedly #(nu/rand-val data/all-fermentables))))))
    (is (csa/valid? ::hops/hops (sut/hops->cbf-hops (take 10 (repeatedly #(nu/rand-val data/all-hops))))))
    (is (csa/valid? ::yeasts/yeasts (sut/yeasts->cbf-yeasts (take 10 (repeatedly #(nu/rand-val data/all-yeasts))))))))

(deftest determine-recipe-type-test
  (testing "Ensure the correct recipe type is selected based on the ingredients"
    #?(:clj (is (thrown-with-msg? Exception #"Cannot determine recipe type with an empty collection of fermentables" (sut/determine-recipe-type []))))
    #?(:cljs (is (thrown-with-msg? js/Error #"Cannot determine recipe type with an empty collection of fermentables" (sut/determine-recipe-type []))))
    (is (= "All Grain" (sut/determine-recipe-type (take 10 (repeatedly #(nu/rand-val (data/select-fermentables {:include-grains? true})))))))
    (is (= "Extract" (sut/determine-recipe-type (take 10 (repeatedly #(nu/rand-val (data/select-fermentables {:include-sugars? true :include-dry-extracts? true :include-extracts? true})))))))
    (is (= "Partial Mash" (sut/determine-recipe-type (concat (take 10 (repeatedly #(nu/rand-val (data/select-fermentables {:include-grains? true})))) (take 10 (repeatedly #(nu/rand-val (data/select-fermentables {:include-sugars? true :include-dry-extracts? true :include-extracts? true}))))))))))

(deftest determine-boil-time-test
  (testing "Ensure boil times are appropriately calculated"
    (let [sample-hop (nu/rand-val data/all-hops)]
      (is (= 60 (sut/determine-boil-time [])))
      (is (= 60 (sut/determine-boil-time [(assoc sample-hop :time 15) (assoc sample-hop :time 30) (assoc sample-hop :time 45)])))
      (is (= 90 (sut/determine-boil-time [(assoc sample-hop :time 15) (assoc sample-hop :time 90) (assoc sample-hop :time 45)]))))))
