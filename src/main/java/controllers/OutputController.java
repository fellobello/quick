package controllers;

import circuit.QuantumOutput;
import circuit.Wire;
import javafx.scene.layout.Pane;
import utils.GridPoint;

import java.util.ArrayList;
import java.util.List;

public class OutputController {
    private final Pane pane;
    private final List<QuantumOutput> outputs;

    public OutputController(Pane pane) {
        this.pane = pane;
        this.outputs = new ArrayList<>();
    }

    public void addOutput(GridPoint position) {
        QuantumOutput output = new QuantumOutput(position);
        outputs.add(output);
        pane.getChildren().add(output.getGraphic());
    }

    // Connect output to a wire
    public void connectOutputToWire(QuantumOutput output, Wire wire) {
        output.connectToWire(wire);
    }

    public List<QuantumOutput> getOutputs() {
        return outputs;
    }

    public void displayOutput() {
        for (QuantumOutput output : outputs) {
            output.updateOutputState(); // Visually display the output
        }
    }
}
