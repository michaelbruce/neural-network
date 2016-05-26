(ns neural-network.core-test
  (:require [clojure.test :refer :all]
            [neural-network.core :refer :all]))

(deftest a-test
  (testing "Miller's first neural network example"
    (is
      (= (network [1 1]) 0.7796714205858819))))

(deftest sigmoid-test
  (testing "Sigmoid functions correctly"
    (is
      (= (sigmoid 3) 0.9525741268224334))))

(deftest synapse-test
  (testing
    "synapses should apply a weight multiplier to the input"
    (is
      (= (synapse [:second-layer :1] 1) 0.3))))

(deftest neuron-test
  "sum the inputs and calculate the sigmoid function of this"
  (is
    (= (neuron 0.3 1) 0.7858349830425586)))
