package circuit;

import utils.*;
import controllers.WireController;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

public class Wire {
    private QuantumState quantumState;
    private List<GridPoint> points;
    private WireController controller;

    public Wire(GridPoint pos, QuantumState quantumState) {
        this.quantumState = quantumState;
        this.points = new ArrayList<>();
        points.add(pos);
    }

    public GridPoint getPos() {
        return points.getFirst();
    }

    public List<GridPoint> getPoints() {
        return points;
    }

    public QuantumState getQuantumState() {
        return quantumState;
    }

    public void setQuantumState(QuantumState quantumState) {
        this.quantumState = quantumState;
    }

    public void addPoint(GridPoint point) {
        points.add(point);
    }
}