(ns brew-bot.sampling.impl-test
  (:require [brew-bot.sampling.impl :as sut]
            [clojure.test :refer [deftest is testing]]))


(deftest xor-shift-test
  (testing "Sanity testing xor-shift functionality"
    (is (= 0 (sut/xor-shift 0)))
    (is (= 8225 (sut/xor-shift 1)))
    (is (= 82250 (sut/xor-shift 10)))))


(deftest generate-seed-test
  (testing "Ensure seeds are generated within the correct range"
    (is (<= 0 (sut/generate-seed)))
    (is (< (sut/generate-seed) sut/max-signed-32-bit-int))))


(deftest next-bitset!-test
  (testing "Ensure the next! function returns the correct values"
    (let [generator (sut/->generator 0)]
      (is (= 833194525 (sut/next-bitset! generator 32)))
      (is (= 903573865 (sut/next-bitset! generator 32)))
      (is (= 3768084132 (sut/next-bitset! generator 32)))))
  (testing "Ensure next works with other types of seed"
    (is (number? (sut/next-bitset! (sut/->generator) 32)))
    (is (= 296680929
           (sut/next-bitset! (sut/->generator "hello") 32)))
    (is (= 2759485929
           (sut/next-bitset! (sut/->generator :bye) 32)))))


(deftest next-double!-test
  (testing "Ensure the next-double! function returns the correct values"
    (let [generator (sut/->generator 0)
          data      (repeatedly 1000 #(sut/next-double! generator))]
      (is (every? number? data))
      (is (every? #(and (<= 0 %) (< % 1)) data)))
    (let [data (repeatedly 1000 sut/next-double!)]
      (is (every? number? data))
      (is (every? #(and (<= 0 %) (< % 1)) data)))
    (let [maximum  sut/max-signed-32-bit-int
          generator (sut/->generator 0)
          data (repeatedly 1000 #(sut/next-double! generator maximum))]
      (is (every? number? data))
      (is (every? #(and (<= 0 %) (< % maximum)) data)))))


(deftest next-int!-test
  (testing "Ensure the next-int! function returns the correct values"
    (let [generator (sut/->generator 0)
          data      (repeatedly 1000 #(sut/next-int! generator))]
      (is (every? number? data))
      (is (every? #(and (<= 0 %) (< % sut/max-unsigned-32-bit-int)) data)))
    (let [data (repeatedly 1000 sut/next-int!)]
      (is (every? number? data))
      (is (every? #(and (<= 0 %) (< % sut/max-unsigned-32-bit-int)) data)))
    (let [maximum   sut/max-signed-32-bit-int
          generator (sut/->generator 0)
          data      (repeatedly 1000 #(sut/next-int! generator maximum))]
      (is (every? number? data))
      (is (every? #(and (<= 0 %) (< % maximum)) data)))))


(deftest apply-weights-test
  (is (= [3 1]
         (sut/apply-weight inc [1 1] 1)))
  (is (= {2 1
          5 2
          9 3
          14 4
          20 5}
         (sut/apply-weights inc [1 2 3 4 5]))))
