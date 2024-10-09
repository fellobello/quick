package circuit;

import java.util.List;
import java.util.ArrayList;
import javafx.scene.shape.Line;
import utils.GridPoint;
import utils.QuantumState;
import javafx.scene.paint.Color;

public class Wire {
    public List<GridPoint> points;             // List of points that define the wire
    private QuantumState quantumState;          // State of the wire
    private boolean selected;                    // Selection state of the wire
    private int currentSegmentIndex;            // Current segment index for graphical representation
    private QuantumInput input;                  // Reference to the connected input
    private QuantumOutput output;                // Reference to the connected output

    public Wire(GridPoint start) {
        points = new ArrayList<>();
        points.add(start);
        quantumState = new QuantumState();       // Initialize the quantum state
        this.selected = false;
        this.currentSegmentIndex = 0;
    }

    public void addPoint(GridPoint point) {
        if (!points.contains(point)) {
            points.add(point);                    // Add new point to the wire
        }
    }

    public QuantumState getQuantumState() {
        return quantumState;                      // Get the current quantum state
    }

    public void setQuantumState(QuantumState quantumState) {
        this.quantumState = quantumState;
        if (output != null) {
            output.updateOutputState();
        }
    }

    public List<GridPoint> getPoints() {
        return points;
    }

    public void delete() {
        points.clear();
        quantumState = null;
    }

    public boolean isNear(GridPoint point) {
        return points.stream().anyMatch(p -> p.distanceTo(point) < 10); // Check proximity to a point
    }

    public boolean isSelected() {
        return selected;                          // Accessor for selection state
    }

    public void setSelected(boolean selected) {
        this.selected = selected;                 // Set selection state
    }

    public Line getGraphic() {
        if (points.size() < 2 || currentSegmentIndex >= points.size() - 1) {
            return null;                          // Not enough points or all segments have been returned
        }

        GridPoint startPoint = points.get(currentSegmentIndex);
        GridPoint endPoint = points.get(currentSegmentIndex + 1);

        Line segment = new Line(startPoint.x(), startPoint.y(), endPoint.x(), endPoint.y());
        segment.setStroke(Color.WHITE);
        segment.getStrokeDashArray().addAll(5d, 5d); // Dashed line style
        currentSegmentIndex++;                       // Move to the next segment index

        return segment;                             // Return the created line segment
    }

    // Connect input to this wire
    public void connectInput(QuantumInput input) {
        this.input = input;                        // Connect the input to the wire
        setQuantumState(input.getQuantumState()); // Set initial state from input
    }

    // Connect output to this wire
    public void connectOutput(QuantumOutput output) {
        this.output = output;                      // Connect the output to the wire
        output.connectToWire(this);                // Establish the connection
        output.updateOutputState();                 // Update the output state based on the wire
    }

    // Get connected input
    public QuantumInput getInput() {
        return input;                              // Get the connected input
    }

    // Get connected output
    public QuantumOutput getOutput() {
        return output;                             // Get the connected output
    }
}