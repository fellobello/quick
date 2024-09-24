package utils;

import utils.ComplexNumber;

public class QuantumState {
    private ComplexNumber[] stateVector;  // Array of complex numbers representing amplitudes

    // Initialize a qubit in the default |0> state
    public QuantumState() {
        stateVector = new ComplexNumber[2];
        stateVector[0] = new ComplexNumber(1.0, 0.0);  // |0> amplitude
        stateVector[1] = new ComplexNumber(0.0, 0.0);  // |1> amplitude
    }

    // For n-qubits
    public QuantumState(int numQubits) {
        int dim = (int) Math.pow(2, numQubits);
        stateVector = new ComplexNumber[dim];  // For n qubits, there are 2^n basis states
        stateVector[0] = new ComplexNumber(1.0, 0.0);  // Initialize in the |0...0> state
        for (int i = 1; i < dim; i++) {
            stateVector[i] = new ComplexNumber(0.0, 0.0);
        }
    }

    // Get the state vector for matrix operations
    public ComplexNumber[] getStateVector() {
        return stateVector;
    }

    // Apply a transformation or gate to the quantum state
    public void applyGate(ComplexNumber[] newState) {
        this.stateVector = newState;
    }
}

