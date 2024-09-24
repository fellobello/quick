package tools;

import javafx.scene.input.MouseEvent;

public interface Tool {
    void onMousePressed(MouseEvent e);
    void onMouseDragged(MouseEvent e);
    void onMouseReleased(MouseEvent e);
}
