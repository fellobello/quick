package controllers;

import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import tools.*;
import controllers.WireController;

public class CircuitEditorController {
    private final Pane pane;              // Pane for drawing elements
    private Tool activeTool;               // Current active tool for drawing/manipulation
    private final WireController wireController;  // Manages wires in the pane

    public CircuitEditorController() {
        pane = new Pane();
        wireController = new WireController(pane);

        activeTool = new WireTool(this); //WireTool test init
        // Set up mouse event handlers
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

    // Handle mouse events
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

    public void addElement(Object element) {
        // Implementation for adding graphical elements to the pane
        // Depending on the design of circuit elements
    }

    public WireController getWireManager() {
        return wireController;             // Accessor for wire manager
    }
}



