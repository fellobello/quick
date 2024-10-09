package controllers;

import circuit.CircuitElement;
import circuit.QuantumInput;
import circuit.Wire;
import javafx.scene.layout.Pane;
import utils.*;

public class InputController {
    private final Pane pane;
    private final GridManager gridManager;

    public InputController(Pane pane, GridManager gridManager) {
        this.pane = pane;
        this.gridManager = gridManager;
    }

    public void addInput(GridPoint pos, QuantumState state) {
        QuantumInput input = new QuantumInput(pos, state);
        GridManager.placeComp(pos, 0);
        pane.getChildren().add(input.getGraphic());
    }

    public void connectInputToWire(QuantumInput input, Wire wire) {
        input.connectToWire(wire);
    }
}
