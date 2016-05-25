(ns neural-network.core)

;(defn backward-propogation [x])

(defn exp [x n]
  (reduce * (repeat n x)))

(defn sigmoid [x]
  (/ 1 (+ 1 (exp 1 (- x)))))

(defn neuron [& inputs]
  "Performs a calculation given inputs"
  (sigmoid (reduce + inputs)))

(defn synapse [weight input]
  "Applys a weight to an input"
  (* weight input))

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

(defn network [inital-inputs]
  "Network based on miller's first example."
  (neuron
    (synapse (:1 (:second-layer @synapses))
             (neuron
               (synapse (:1 (:first-layer @synapses)) (first inital-inputs))
               (synapse (:2 (:first-layer @synapses)) (second inital-inputs))))
    (synapse (:2 (:second-layer @synapses))
             (neuron
               (synapse (:3 (:first-layer @synapses)) (first inital-inputs))
               (synapse (:4 (:first-layer @synapses)) (second inital-inputs))))
    (synapse (:3 (:second-layer @synapses))
             (neuron
               (synapse (:5 (:first-layer @synapses)) (first inital-inputs))
               (synapse (:6 (:first-layer @synapses)) (second inital-inputs))))))
