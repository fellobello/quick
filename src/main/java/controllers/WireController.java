package controllers;

import circuit.Wire;
import javafx.scene.layout.Pane;
import utils.GridPoint;

import java.util.ArrayList;
import java.util.List;

public class WireController {
    private final List<Wire> wires = new ArrayList<>();  // List of wires managed by this controller
    private final Pane pane;                              // Pane to display wires

    public WireController(Pane pane) {
        this.pane = pane;                                 // Initialize the pane reference
    }

    public void addWire(Wire wire) {
        wires.add(wire);
        pane.getChildren().add(wire.getGraphic());       // Add the wire's graphic to the pane
    }

    public void removeWire(Wire wire) {
        wires.remove(wire);
        pane.getChildren().remove(wire.getGraphic());    // Remove the wire's graphic from the pane
    }

    public Wire getSelectedWire() {
        return wires.stream().filter(Wire::isSelected).findFirst().orElse(null);  // Get the currently selected wire
    }

    public void selectWire(Wire wire) {
        wires.forEach(w -> w.setSelected(false));         // Deselect all wires
        wire.setSelected(true);                           // Select the given wire
    }

    public Wire getWireNear(GridPoint point) {
        return wires.stream().filter(wire -> wire.isNear(point)).findFirst().orElse(null);  // Find the nearest wire
    }

    public void updateWireDisplay(Wire wire) {
        // Remove existing graphical representation
        pane.getChildren().remove(wire.getGraphic());
        // Re-add the updated graphical representation
        pane.getChildren().add(wire.getGraphic());
    }
}
