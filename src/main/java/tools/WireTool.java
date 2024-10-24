package tools;

import controllers.CircuitEditorController;
import javafx.scene.input.MouseEvent;
import circuit.Wire;
import utils.*;

public class WireTool implements Tool {
    private boolean drawingWire = false;
    private Wire currentWire;
    private final CircuitEditorController editorController;

    public WireTool(CircuitEditorController editorController) {
        this.editorController = editorController;
    }

    public void onMousePressed(MouseEvent e) {
        GridPoint startPoint = GridManager.snapToGrid(e.getX(), e.getY()); // Snap mouse position to grid
        QuantumState initialState = new QuantumState(1); // Example state
        currentWire = new Wire(startPoint, initialState);
        drawingWire = true;
        editorController.getWireController().addWire(currentWire.getPos(), initialState); // Initially add the wire with quantum state
    }

    public void onMouseDragged(MouseEvent e) {
        if (drawingWire) {
            GridPoint nextPoint = GridManager.snapToGrid(e.getX(), e.getY());
            currentWire.addPoint(nextPoint); // Add the next point to the wire

            // Check if we have at least two points
            if (currentWire.getPoints().size() >= 2) {
                editorController.getWireController().updateWireDisplay(currentWire); // Update the graphic display
            }
        }
    }

    public void onMouseReleased(MouseEvent e) {
        if (drawingWire) {
            GridPoint endPoint = GridManager.snapToGrid(e.getX(), e.getY());
            currentWire.addPoint(endPoint); // Add the end point to the wire
            drawingWire = false; // Stop drawing
            editorController.getWireController().updateWireDisplay(currentWire); // Final update on release
        }
    }
}
