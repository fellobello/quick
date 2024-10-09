package controllers;

import circuit.Wire;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import utils.*;
import java.util.ArrayList;
import java.util.List;

public class WireController {
    private final List<Wire> wires = new ArrayList<>();
    private final Pane pane;
    private final GridManager gridManager;

    public WireController(Pane pane, GridManager gridManager) {
        this.pane = pane;
        this.gridManager = gridManager;
    }

    public void addWire(Wire wire) {
        wires.add(wire);
        Line graphic = wire.getGraphic();
        if (graphic != null) {
            pane.getChildren().add(graphic); // add the wire's graphic to the pane if it has enough points
        }

        gridManager.placeComp(
    }

    public void removeWire(Wire wire) {
        wires.remove(wire);
        pane.getChildren().remove(wire.getGraphic());    // remove the wire's graphic from the pane
    }

    public Wire getSelectedWire() {
        return wires.stream().filter(Wire::isSelected).findFirst().orElse(null);  // get the currently selected wire
    }

    public void selectWire(Wire wire) {
        wires.forEach(w -> w.setSelected(false));         // deselect all wires
        wire.setSelected(true);                           // select the given wire
    }

    public Wire getWireNear(GridPoint point) {
        return wires.stream().filter(wire -> wire.isNear(point)).findFirst().orElse(null);  // find the nearest wire
    }

    public void updateWireDisplay(Wire wire) {
        Line segment;
        while ((segment = wire.getGraphic()) != null) {
            pane.getChildren().add(segment); // add the new segment to the pane
        }
    }
}

