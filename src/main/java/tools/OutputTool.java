package tools;

import controllers.OutputController;
import controllers.CircuitEditorController;
import javafx.scene.input.MouseEvent;
import utils.*;


public class OutputTool implements Tool {
    private final CircuitEditorController editor;

    public OutputTool(CircuitEditorController editor) {
        this.editor = editor;
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        GridPoint point = GridManager.snapToGrid(e.getX(), e.getY());
        editor.getOutputController().addOutput(point);
    }

    @Override
    public void onMouseDragged(MouseEvent e) {
        // handle dragging if necessary
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
        // handle releasing if necessary
    }
}
