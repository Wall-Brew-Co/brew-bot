(ns brew-bot.util-test
  (:require [brew-bot.util :as sut]
            [clojure.spec.alpha :as csa]
            [common-beer-data.core :as data]
            [common-beer-format.fermentables :as fermentables]
            [common-beer-format.hops :as hops]
            [common-beer-format.yeasts :as yeasts]
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
    (let [random-fermentables (sut/fermentables->cbf-fermentables (take 100 (repeatedly #(nu/rand-val data/all-fermentables))))
          sample-fermentable  (nu/rand-val data/all-fermentables)
          random-hops         (sut/hops->cbf-hops (take 100 (repeatedly #(nu/rand-val data/all-hops))))
          sample-hop          (nu/rand-val data/all-hops)
          random-yeasts       (sut/yeasts->cbf-yeasts (take 100 (repeatedly #(nu/rand-val data/all-yeasts))))
          sample-yeast        (nu/rand-val data/all-yeasts)]
      (is (csa/valid? ::fermentables/fermentables random-fermentables))
      (is (false? (empty? random-fermentables)))
      (is (distinct? (map #(get-in % [:fermentable :name]) random-fermentables)))
      (is (= 3 (:amount (:fermentable (nu/only (sut/fermentables->cbf-fermentables [(assoc sample-fermentable :amount 1) (assoc sample-fermentable :amount 2)]))))))
      (is (csa/valid? ::hops/hops random-hops))
      (is (false? (empty? random-hops)))
      (is (distinct? (map #(get-in % [:fermentable :name]) random-hops)))
      (is (= 1 (count (sut/hops->cbf-hops [(assoc sample-hop :time 15) (assoc sample-hop :time 15)]))))
      (is (= 2 (count (sut/hops->cbf-hops [(assoc sample-hop :time 15) (assoc sample-hop :time 45)]))))
      (is (= 2 (count (sut/hops->cbf-hops [(assoc sample-hop :time 15 :use "aroma") (assoc sample-hop :time 15 :use "mash")]))))
      (is (csa/valid? ::yeasts/yeasts random-yeasts))
      (is (false? (empty? random-yeasts)))
      (is (distinct? (map #(get-in % [:fermentable :name]) random-yeasts)))
      (is (= 3 (:amount (:yeast (nu/only (sut/yeasts->cbf-yeasts [(assoc sample-yeast :amount 1) (assoc sample-yeast :amount 2)])))))))))


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
