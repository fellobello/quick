package utils;
import tools.*;

public class GridManager {
    private static final int GRID_SIZE = 40;
    public int width = 0;
    public int height = 0;
    public Tool[][] grid = new Tool[width][height];

    GridManager(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Tool[width][height];
    }

    public boolean placeComponent(GridPoint pos, Tool tool) {
        if(isOccupied(pos)) { return false; }
        grid[(int) pos.x()][(int) pos.y()] = tool;

        return true;
    }

    public void removeComponent(GridPoint pos) {
        if(!isOccupied(pos)) { return; }

        grid[(int) pos.x()][(int) pos.y()] = null;
    }

    public boolean isOccupied(GridPoint pos) {
        return grid[(int) pos.x()][(int) pos.y()] != null;
    }

    public Tool getComp(GridPoint pos) {
        if(!isOccupied(pos)) { return null; }

        return grid[(int) pos.x()][(int) pos.y()];
    }

    public Tool[][] getGrid() {
        return grid;
    }

    public static double snapToGrid(double value) {
        return Math.round(value / GRID_SIZE) * GRID_SIZE;
    }

    public static GridPoint snapToGrid(double x, double y) {
        double snappedX = snapToGrid(x);
        double snappedY = snapToGrid(y);
        return new GridPoint(snappedX, snappedY);
    }
}
