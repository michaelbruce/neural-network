(ns neural-network.core)

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

(defn exp [x n]
  (reduce * (repeat n x)))

(defn sigmoid [x]
  (/ 1 (+ 1 (exp 1 (- x)))))

(defn neuron [& inputs]
  "Performs a calculation given inputs"
  (sigmoid (reduce + inputs)))

(defn synapse [location input]
  "Applys a weight to an input"
  (let [weight ((second location)
                ((first location) @synapses))]
    (* weight input)))

(defn network [inital-inputs]
  "Network based on miller's first example."
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
