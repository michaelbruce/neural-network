# neural-network

A Clojure library designed to ... well, that part is up to you.

## Usage

FIXME

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

### Notes

You need to provide a 'target' for the output for a network.
e.g estimating your score on a test given hours of study/sleep should be given out of 100.
the range there will be 0 to 1.

What is a Neural Network composed of?

Synapses and Neurons are the building blocks.

`-----` lines represent synapses

synapses take input and multiple it by a weight (the strength of the input determining the output).

neurons add the outputs from all synapses and apply an activation function.

training a neural network is done by calibrating these weights, there are two key steps
that affect this, forward propogation and backward propogation.

Numbers are the easiest data type for neutral networks to work with.

Forward propogation - we apply a set of weights to the input and calculate an output.
For the first forward propagation, the set of weights is selected randomly.

during forward propogation, an input has a first operation performed on it,
an activation function is then applied transforming the input signal input an output signal.

Backward propogation - measure the margin of error from the output and adjust the weights accordingly.

So a neural network functions by taking rounds of inputs, randomly assigning weights and running them through a neural net.
Test data has the output that we can compare the networks output to.

#### Terminology

Regression - under the branch of statistical modelling or data analysis.
    - process used to estimate relationships amoung variables.

The Natural Exponent - like pi, e is also a useful number, it is approximately 2.7182..
http://www.purplemath.com/modules/expofcns5.htm

Sigmoid function - the idea with this function is  that something changing will not keep changing forever.
sigmoid, meaning s-like.
