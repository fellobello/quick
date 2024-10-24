package controllers;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import tools.*;
import utils.GridManager;
import utils.QuantumState;
import utils.GridPoint;
import circuit.Wire;

public class CircuitEditorController {
    private final Pane pane;
    private final GridManager gridManager;
    private final WireController wireController;
    private final InputController inputController;
    private final OutputController outputController;
    private Tool activeTool;

    private static final int PANE_WIDTH = 800;    // Set a fixed pane width
    private static final int PANE_HEIGHT = 600;   // Set a fixed pane height
    private static final int GRID_POINT_DISTANCE = 40; // Each grid cell is 40px by 40px

    public CircuitEditorController(Pane pane) {
        this.pane = pane;

        // Set the pane's fixed size
        pane.setPrefSize(PANE_WIDTH, PANE_HEIGHT);
        pane.setStyle("-fx-background-color: #241d31;");

        // Calculate grid width and height based on pane size and grid point distance
        int gridWidth = PANE_WIDTH / GRID_POINT_DISTANCE;
        int gridHeight = PANE_HEIGHT / GRID_POINT_DISTANCE;

        // Initialize the GridManager with the calculated grid dimensions
        this.gridManager = new GridManager();

        wireController = new WireController(pane, gridManager);
        inputController = new InputController(pane, gridManager);
        outputController = new OutputController(pane, gridManager);
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

    public WireController getWireController() {
        return wireController;
    }

    public InputController getInputController() {
        return inputController;
    }

    public OutputController getOutputController() {
        return outputController;
    }

    public GridManager getGridManager() { return gridManager; }
}
