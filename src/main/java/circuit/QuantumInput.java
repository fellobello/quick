package circuit;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import utils.GridPoint;
import utils.QuantumState;
import circuit.Wire;

public class QuantumInput {
    private QuantumState quantumState;
    private Circle graphic;
    private GridPoint position;
    private Wire connectedWire;

    public QuantumInput(GridPoint position, QuantumState quantumState) {
        this.position = position;
        this.quantumState = quantumState;
        this.graphic = new Circle(position.getX(), position.getY(), 10, Color.GREEN); // Visual element
        this.connectedWire = null;
    }

    public void connectToWire(Wire wire) {
        this.connectedWire = wire;
        wire.setQuantumState(quantumState);  // Pass quantum state to the wire
    }

    public Circle getGraphic() {
        return graphic;
    }

    public QuantumState getQuantumState() {
        return quantumState;
    }

    public GridPoint getPosition() {
        return position;
    }

    public void setQuantumState(QuantumState state) {
        this.quantumState = state;
        if (connectedWire != null) {
            connectedWire.setQuantumState(state);  // Update wire state
        }
    }
}