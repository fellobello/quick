package circuit;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import utils.GridPoint;
import utils.QuantumState;

public class QuantumInput {
    private QuantumState quantumState;
    private Circle graphic;
    private GridPoint pos;

    public QuantumInput(GridPoint pos, QuantumState quantumState) {
        this.pos = pos;
        this.quantumState = quantumState;
        this.graphic = new Circle(pos.getX(), pos.getY(), 10, Color.GREEN);
    }

    public Circle getGraphic() {
        return graphic;
    }

    public QuantumState getQuantumState() {
        return quantumState;
    }

    public GridPoint getPos() {
        return pos;
    }

    public void setQuantumState(QuantumState state) {
        this.quantumState = state;
    }
}