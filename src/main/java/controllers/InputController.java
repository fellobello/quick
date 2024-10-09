package controllers;

import circuit.QuantumInput;
import circuit.Wire;
import javafx.scene.layout.Pane;
import utils.GridPoint;
import utils.QuantumState;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    private final Pane pane;
    private final List<QuantumInput> inputs;

    public InputController(Pane pane) {
        this.pane = pane;
        this.inputs = new ArrayList<>();
    }

    public void addInput(GridPoint position, QuantumState state) {
        QuantumInput input = new QuantumInput(position, state);
        inputs.add(input);
        pane.getChildren().add(input.getGraphic());
    }

    // Connect input to a wire
    public void connectInputToWire(QuantumInput input, Wire wire) {
        input.connectToWire(wire);
    }

    public List<QuantumInput> getInputs() {
        return inputs;
    }
}
