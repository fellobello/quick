package controllers;

import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import tools.*;
import utils.QuantumState;
import utils.GridPoint;
import circuit.Wire;

public class CircuitEditorController {
    private final Pane pane;
    private final WireController wireController;
    private final InputController inputController;
    private final OutputController outputController;
    private Tool activeTool;

    public CircuitEditorController(Pane pane) {
        this.pane = pane;
        pane.setStyle("-fx-background-color: #241d31;");

        wireController = new WireController(pane);
        inputController = new InputController(pane);
        outputController = new OutputController(pane);
        activeTool = new WireTool(this);

        pane.setOnMousePressed(this::handleMousePressed);
        pane.setOnMouseDragged(this::handleMouseDragged);
        pane.setOnMouseReleased(this::handleMouseReleased);
    }

    public Pane getPane() {
        return pane;
    }

    public void setActiveTool(Tool tool) {
        activeTool = tool;
    }

    private void handleMousePressed(MouseEvent e) {
        if (activeTool != null) {
            activeTool.onMousePressed(e);
        }
    }

    private void handleMouseDragged(MouseEvent e) {
        if (activeTool != null) {
            activeTool.onMouseDragged(e);
        }
    }

    private void handleMouseReleased(MouseEvent e) {
        if (activeTool != null) {
            activeTool.onMouseReleased(e);
        }
    }

    public void addInputState(QuantumState state, GridPoint position) {
        inputController.addInput(position, state);  // Add an input with its quantum state
    }

    public void displayOutputState() {
        outputController.displayOutput();  // Display output state on the pane
    }

    public WireController getWireController() {
        return wireController;
    }

    public InputController getInputController() {
        return inputController;
    }

    public OutputController getOutputController() {
        return outputController;
    }
}
