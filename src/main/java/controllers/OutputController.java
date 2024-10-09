package controllers;

import circuit.QuantumOutput;
import javafx.scene.layout.Pane;
import utils.*;


public class OutputController {
    private final Pane pane;
    private final GridManager gridManager;

    public OutputController(Pane pane, GridManager gridManager) {
        this.pane = pane;
        this.gridManager = gridManager;
    }

    public void addOutput(GridPoint position) {
        QuantumOutput output = new QuantumOutput(position);
        pane.getChildren().add(output.getGraphic());
    }

}
