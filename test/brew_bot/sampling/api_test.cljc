(ns brew-bot.sampling.api-test
  (:require [brew-bot.sampling.api :as sut]
            [clojure.test :refer [deftest is testing]]))


(deftest with-seed-test
  (testing "An encapsulating `with-seed` should behave the same as re-using a generator."
    (let [seed     12
          response "caaebcdeccabaaccaeeabdbcd"]
      (sut/with-seed seed
                     (is (= response
                            (apply str (take 25 (sut/sample "abcde"))))))
      (is (= response
             (apply str (take 25 (sut/sample seed "abcde"))))))))
