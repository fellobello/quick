package circuit;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import utils.QuantumState;
import utils.GridPoint;

public class QuantumOutput {
    private QuantumState quantumState;
    private Rectangle graphic;
    private GridPoint position;
    private Wire connectedWire;

    public QuantumOutput(GridPoint position) {
        this.position = position;
        this.graphic = new Rectangle(position.getX() - 10, position.getY() - 10, 20, 20);
        this.graphic.setFill(Color.GREY);
        this.connectedWire = null;
    }

    public void connectToWire(Wire wire) {
        this.connectedWire = wire;
        updateOutputState();
    }

    public void updateOutputState() {
        if (connectedWire != null) {
            this.quantumState = connectedWire.getQuantumState();
            updateGraphic();
        }
    }

    private void updateGraphic() {
        if (quantumState.isSuperposition()) {
            graphic.setFill(Color.PURPLE); // Superposition state
        } else if (quantumState.isZero()) {
            graphic.setFill(Color.BLUE);   // Zero state
        } else if (quantumState.isOne()) {
            graphic.setFill(Color.RED);    // One state
        } else {
            graphic.setFill(Color.GREY);   // No state / default
        }
    }

    public Rectangle getGraphic() {
        return graphic;
    }

    public QuantumState getQuantumState() {
        return quantumState;
    }

    public GridPoint getPosition() {
        return position;
    }
}
