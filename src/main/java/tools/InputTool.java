package tools;

import controllers.InputController;
import controllers.CircuitEditorController;
import javafx.scene.input.MouseEvent;
import utils.GridPoint;
import utils.GridUtils;
import utils.QuantumState;

public class InputTool implements Tool {
    private final CircuitEditorController editor;

    public InputTool(CircuitEditorController editor) {
        this.editor = editor;
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        GridPoint point = GridUtils.snapToGrid(e.getX(), e.getY());
        editor.getInputController().addInput(point, new QuantumState(1));
    }

    @Override
    public void onMouseDragged(MouseEvent e) {
        // Handle dragging if necessary
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
        // Handle releasing if necessary
    }
}
