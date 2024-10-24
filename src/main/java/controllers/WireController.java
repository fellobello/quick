package controllers;

import java.util.List;
import java.util.ArrayList;

import javafx.scene.paint.Color;
import circuit.Wire;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import utils.GridPoint;
import utils.GridManager;
import utils.QuantumState;

public class WireController {
    private final Pane pane;
    private final GridManager gridManager;
    private static List<List<GridPoint>> wires;

    public WireController(Pane pane, GridManager gridManager) {
        this.pane = pane;
        this.gridManager = gridManager;
        this.wires = new ArrayList<>();
    }

    public void addWire(GridPoint pos, QuantumState state) {
        gridManager.placeComp(pos, 0);
        List<GridPoint> wirePath = new ArrayList<>();
        wirePath.add(pos);
        wires.add(wirePath);

        // Add initial wire display with quantum state
        Line wireGraphic = createWireGraphic(pos, state);
        pane.getChildren().add(wireGraphic);
    }

    public Line createWireGraphic(GridPoint pos, QuantumState state) {
        // Convert grid positions to pixel positions
        double gridSpacing = 40.0;
        double startX = pos.getXIndex() * gridSpacing + gridSpacing / 2;
        double startY = pos.getYIndex() * gridSpacing + gridSpacing / 2;

        Line line = new Line(startX, startY, startX, startY); // start and end are same for now
        line.setStrokeWidth(3);
        //line.setStroke(state.getColor()); Use the QuantumState's color representation
        line.setStroke(Color.BLUE); // placeholder

        return line;
    }

    public void updateWireDisplay(Wire wire) {
        List<GridPoint> wirePoints = wire.getPoints();
        if (wirePoints.size() < 2) return; // Need at least two points to form a wire

        GridPoint start = wirePoints.get(wirePoints.size() - 2);
        GridPoint end = wirePoints.get(wirePoints.size() - 1);

        double gridSpacing = 40.0;
        double startX = start.getXIndex() * gridSpacing + gridSpacing / 2;
        double startY = start.getYIndex() * gridSpacing + gridSpacing / 2;
        double endX = end.getXIndex() * gridSpacing + gridSpacing / 2;
        double endY = end.getYIndex() * gridSpacing + gridSpacing / 2;

        Line line = new Line(startX, startY, endX, endY);
        line.setStrokeWidth(3);
        //line.setStroke(wire.getQuantumState().getColor());
        line.setStroke(Color.BLUE); // placeholder

        pane.getChildren().add(line); // Add the wire to the display
    }
}
