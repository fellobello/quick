package circuit;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Line;
import utils.GridPoint;
import utils.QuantumState;

public class Wire {
    private final List<GridPoint> points;      // List of points that define the wire
    private QuantumState quantumState;          // State of the wire
    private boolean selected;                    // Selection state of the wire

    public Wire(GridPoint start, GridPoint end) {
        points = new ArrayList<>();
        points.add(start);
        points.add(end);
        quantumState = new QuantumState();     // Initialize the quantum state
        this.selected = false;                  // Default selection state
    }

    public void addPoint(GridPoint point) {
        points.add(point);                     // Add a new point to the wire
    }

    public QuantumState getQuantumState() {
        return quantumState;                   // Accessor for quantum state
    }

    public List<GridPoint> getPoints() {
        return points;                         // Accessor for the points
    }

    public void delete() {
        points.clear();                        // Clear all points in the wire
        quantumState = null;                   // Reset quantum state
    }

    public boolean isNear(GridPoint point) {
        return points.stream().anyMatch(p -> p.distanceTo(point) < 10); // Check proximity to a point
    }

    public boolean isSelected() {
        return selected;                       // Accessor for selection state
    }

    public void setSelected(boolean selected) {
        this.selected = selected;              // Set selection state
    }

    public Line getGraphic() {
        Line line = new Line();
        if (!points.isEmpty()) {
            GridPoint startPoint = points.get(0);
            line.setStartX(startPoint.getX());
            line.setStartY(startPoint.getY());
        }

        for (int i = 0; i < points.size() - 1; i++) {
            GridPoint currentPoint = points.get(i);
            GridPoint nextPoint = points.get(i + 1);
            Line segment = new Line(currentPoint.getX(), currentPoint.getY(), nextPoint.getX(), nextPoint.getY());

            if (selected) {
                segment.setStrokeWidth(3); // Thicker line for selected wire
                segment.setStroke(javafx.scene.paint.Color.RED); // Change color to red
            } else {
                segment.setStrokeWidth(1); // Normal line width
                segment.setStroke(javafx.scene.paint.Color.BLACK); // Default color
            }

            // Add segment to line (you could also create a group for multiple segments if desired)
            line.getStrokeDashArray().addAll(5d, 5d); // Example of dashed line for display
        }

        return line;
    }
}


