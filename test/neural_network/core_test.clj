(ns neural-network.core-test
  (:require [clojure.test :refer :all]
            [neural-network.core :refer :all]))

(deftest a-test
  (testing "Miller's first neural network example"
    (is
      (network [1 1]) 0.97)))

(deftest sigmoid-test
  (testing "Sigmoid functions correctly"
    (is
      (= (sigmoid 3) 0.9525741268224334))))
