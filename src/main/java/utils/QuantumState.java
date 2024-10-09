package utils;

public class QuantumState {
    private ComplexNumber[] stateVector;  // Array of complex numbers representing amplitudes

    // Initialize a qubit in the default |0⟩ state
    public QuantumState() {
        stateVector = new ComplexNumber[2];
        stateVector[0] = new ComplexNumber(1.0, 0.0);  // |0⟩ amplitude
        stateVector[1] = new ComplexNumber(0.0, 0.0);  // |1⟩ amplitude
    }

    // For n-qubits
    public QuantumState(int numQubits) {
        int dim = (int) Math.pow(2, numQubits);
        stateVector = new ComplexNumber[dim];  // For n qubits, there are 2^n basis states
        stateVector[0] = new ComplexNumber(1.0, 0.0);  // Initialize in the |0...0⟩ state
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
        if (newState.length == stateVector.length) {
            this.stateVector = newState;
            normalizeState();
        }
    }

    // Normalize the state vector (sum of probabilities = 1)
    private void normalizeState() {
        double norm = 0.0;

        // Calculate the sum of the squares of the magnitudes
        for (ComplexNumber amplitude : stateVector) {
            norm += amplitude.mod() * amplitude.mod(); // Use mod() to calculate magnitude squared
        }

        norm = Math.sqrt(norm); // Calculate the norm (magnitude of the state vector)

        // Normalize each amplitude
        for (int i = 0; i < stateVector.length; i++) {
            ComplexNumber amplitude = stateVector[i];
            // Divide the amplitude by the norm (as a ComplexNumber)
            if (norm != 0) {
                double realPart = amplitude.getRe() / norm;         // Normalize the real part
                double imaginaryPart = amplitude.getIm() / norm; // Normalize the imaginary part
                stateVector[i] = new ComplexNumber(realPart, imaginaryPart); // Create a new normalized ComplexNumber
            }
        }
    }

    // Check if the quantum state is in the |0⟩ state
    public boolean isZero() {
        return stateVector[0].equals(new ComplexNumber(1.0, 0.0)) && stateVector[1].equals(new ComplexNumber(0.0, 0.0));
    }

    // Check if the quantum state is in the |1⟩ state
    public boolean isOne() {
        return stateVector[1].equals(new ComplexNumber(1.0, 0.0)) && stateVector[0].equals(new ComplexNumber(0.0, 0.0));
    }

    // Check if the quantum state is in a superposition
    public boolean isSuperposition() {
        return !(isZero() || isOne());
    }

    // Update the quantum state for user interaction (toggle between |0⟩, |1⟩, and superposition)
    public void toggleState() {
        if (isZero()) {
            // Transition to |1⟩
            stateVector[0] = new ComplexNumber(0.0, 0.0);
            stateVector[1] = new ComplexNumber(1.0, 0.0);
        } else if (isOne()) {
            // Transition to superposition (|+⟩ = 1/√2(|0⟩ + |1⟩))
            stateVector[0] = new ComplexNumber(1.0 / Math.sqrt(2), 0.0);
            stateVector[1] = new ComplexNumber(1.0 / Math.sqrt(2), 0.0);
        } else {
            // Transition back to |0⟩
            stateVector[0] = new ComplexNumber(1.0, 0.0);
            stateVector[1] = new ComplexNumber(0.0, 0.0);
        }
        normalizeState();
    }
}


