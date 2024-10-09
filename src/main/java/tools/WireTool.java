package tools;

import controllers.CircuitEditorController;
import javafx.scene.input.MouseEvent;
import circuit.Wire;
import utils.GridPoint;
import utils.GridUtils;

public class WireTool implements Tool {
    private boolean drawingWire = false;
    private Wire currentWire;
    private final CircuitEditorController editorController;

    public WireTool(CircuitEditorController editorController) {
        this.editorController = editorController;
    }

    // called when mouse is pressed down (start drawing a wire)
    public void onMousePressed(MouseEvent e) {
        GridPoint startPoint = GridUtils.snapToGrid(e.getX(), e.getY()); // Snap mouse position to grid
        currentWire = new Wire(startPoint);
        drawingWire = true;
        editorController.getWireController().addWire(currentWire); // Initially add the wire to the controller
    }

    // called when mouse is dragged (update the wire as the user drags the mouse)
    public void onMouseDragged(MouseEvent e) {
        if (drawingWire) {
            GridPoint nextPoint = GridUtils.snapToGrid(e.getX(), e.getY());
            currentWire.addPoint(nextPoint); // Add the next point to the wire

            // Check if we have at least two points
            if (currentWire.getPoints().size() >= 2) {
                editorController.getWireController().updateWireDisplay(currentWire); // Update the graphic display
            }
        }
    }

    // called when mouse is released (finish drawing the wire)
    public void onMouseReleased(MouseEvent e) {
        if (drawingWire) {
            GridPoint endPoint = GridUtils.snapToGrid(e.getX(), e.getY());
            currentWire.addPoint(endPoint); // Add the end point to the wire
            drawingWire = false; // Stop drawing
            editorController.getWireController().updateWireDisplay(currentWire); // Final update on release
        }
    }

    // handle selection of a wire (if user clicks near a wire)
    public void onMouseClicked(MouseEvent e) {
        GridPoint clickPoint = GridUtils.snapToGrid(e.getX(), e.getY());
        Wire selectedWire = editorController.getWireController().getWireNear(clickPoint);
        if (selectedWire != null) {
            editorController.getWireController().selectWire(selectedWire);
        }
    }

    // delete the currently selected wire
    public void deleteSelectedWire() {
        Wire selectedWire = editorController.getWireController().getSelectedWire();
        if (selectedWire != null) {
            editorController.getWireController().removeWire(selectedWire);
        }
    }
}


