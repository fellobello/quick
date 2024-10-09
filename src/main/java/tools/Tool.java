package tools;

import controllers.CircuitEditorController;
import javafx.scene.input.MouseEvent;

public interface Tool {
    void onMousePressed(MouseEvent e);
    void onMouseDragged(MouseEvent e);
    void onMouseReleased(MouseEvent e);

    default void setEditor(CircuitEditorController editor) {
        // Default implementation does nothing
    }
}
