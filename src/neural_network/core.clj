; lispy - ctrl-k goes to newline with scope )))
(ns neural-network.core
  (:import (java.lang Math)))

(defonce initial-inputs [1 1])

(defonce synapses (atom {:first-layer {:1 0.8
                                      :2 0.4
                                      :3 0.3
                                      :4 0.2
                                      :5 0.9
                                      :6 0.5}
                        :second-layer {:1 0.3
                                       :2 0.5
                                       :3 0.9}}))

(defn sigmoid [x]
  (/ 1 (+ 1 (java.lang.Math/exp (- x)))))

(defn sigmoid-prime [x]
  (* (sigmoid x) (- 1 (sigmoid x))))

(defn delta-output-sum [sum target calculated]
  (* (sigmoid-prime sum) (- target calculated)))

(defn neuron [& inputs]
  "Performs a calculation given inputs"
  (sigmoid (reduce + inputs)))

(defn synapse [location input]
  "Applys a weight to an input"
  (let [weight ((second location)
                ((first location) @synapses))]
    (* weight input)))

(defn network [inital-inputs]
  "Forward propogation based on miller's first example."
  (neuron
    (synapse [:second-layer :1]
             (neuron
               (synapse [:first-layer :1] (first inital-inputs))
               (synapse [:first-layer :2] (second inital-inputs))))
    (synapse [:second-layer :2]
             (neuron
               (synapse [:first-layer :3] (first inital-inputs))
               (synapse [:first-layer :4] (second inital-inputs))))
    (synapse [:second-layer :3]
             (neuron
               (synapse [:first-layer :5] (first inital-inputs))
               (synapse [:first-layer :6] (second inital-inputs))))))

; actions
; initial source passes value through synapse
; synapse weighs value and passes this to neuron
; neuron sums this with any other inputs and calculated the sigmoid of the result

