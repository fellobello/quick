package tools;

import controllers.OutputController;
import controllers.CircuitEditorController;
import javafx.scene.input.MouseEvent;
import utils.GridPoint;
import utils.GridUtils;

public class OutputTool implements Tool {
    private final CircuitEditorController editor;

    public OutputTool(CircuitEditorController editor) {
        this.editor = editor;
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        GridPoint point = GridUtils.snapToGrid(e.getX(), e.getY());
        editor.getOutputController().addOutput(point); // Add output at clicked position
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
