package circuit;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import utils.QuantumState;
import utils.GridPoint;
import circuit.Wire;

public class QuantumOutput {
    private QuantumState quantumState;
    private Rectangle graphic;
    private GridPoint position;
    private Wire connectedWire;

    public QuantumOutput(GridPoint position) {
        this.position = position;
        this.graphic = new Rectangle(position.getX() - 10, position.getY() - 10, 20, 20);
        this.graphic.setFill(Color.GREY); // Default to grey when no state
        this.connectedWire = null;
    }

    public void connectToWire(Wire wire) {
        this.connectedWire = wire;
        updateOutputState(); // Sync state on connection
    }

    public void updateOutputState() {
        if (connectedWire != null) {
            this.quantumState = connectedWire.getQuantumState();  // Get quantum state from wire
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
