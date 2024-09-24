package tools;

import controllers.CircuitEditorController;
import controllers.WireController;
import javafx.scene.input.MouseEvent;
import circuit.Wire;
import utils.GridPoint;
import utils.GridUtils;

public class WireTool implements Tool {
    private boolean drawingWire = false;  // Track if we're currently drawing a wire
    private Wire currentWire;
    private final CircuitEditorController editorController;

    public WireTool(CircuitEditorController editorController) {
        this.editorController = editorController;
    }

    // Called when mouse is pressed down (start drawing a wire)
    public void onMousePressed(MouseEvent e) {
        GridPoint startPoint = GridUtils.snapToGrid(e.getX(), e.getY());  // Snap mouse position to grid
        currentWire = new Wire(startPoint, startPoint);
        drawingWire = true;
        editorController.getWireManager().addWire(currentWire);
    }

    // Called when mouse is dragged (update the wire as the user drags the mouse)
    public void onMouseDragged(MouseEvent e) {
        if (drawingWire) {
            GridPoint nextPoint = GridUtils.snapToGrid(e.getX(), e.getY());
            currentWire.addPoint(nextPoint);
            editorController.getWireManager().updateWireDisplay(currentWire);  // Visually update the wire in the editor
        }
    }

    // Called when mouse is released (finish drawing the wire)
    public void onMouseReleased(MouseEvent e) {
        if (drawingWire) {
            drawingWire = false;
            // Ensure the wire ends at a grid point
            GridPoint endPoint = GridUtils.snapToGrid(e.getX(), e.getY());
            currentWire.addPoint(endPoint);
        }
    }

    // Handle selection of a wire (if user clicks near a wire)
    public void onMouseClicked(MouseEvent e) {
        GridPoint clickPoint = GridUtils.snapToGrid(e.getX(), e.getY());
        Wire selectedWire = editorController.getWireManager().getWireNear(clickPoint);
        if (selectedWire != null) {
            editorController.getWireManager().selectWire(selectedWire);
        }
    }

    // Delete the currently selected wire
    public void deleteSelectedWire() {
        Wire selectedWire = editorController.getWireManager().getSelectedWire();
        if (selectedWire != null) {
            editorController.getWireManager().removeWire(selectedWire);
        }
    }
}


