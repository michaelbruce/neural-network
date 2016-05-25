(ns neural-network.core-test
  (:require [clojure.test :refer :all]
            [neural-network.core :refer :all]))

(deftest a-test
  (testing "Miller's first neural network example"
    (is
      (network [1 1]) 1.235)))
