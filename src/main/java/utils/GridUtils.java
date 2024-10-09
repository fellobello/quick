package utils;

import javafx.geometry.Point2D;

public class GridUtils {
    private static final int GRID_SIZE = 40;

    public static double snapToGrid(double value) {
        return Math.round(value / GRID_SIZE) * GRID_SIZE;
    }

    public static GridPoint snapToGrid(double x, double y) {
        double snappedX = snapToGrid(x);
        double snappedY = snapToGrid(y);
        return new GridPoint(snappedX, snappedY);
    }
}
