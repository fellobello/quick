package utils;
import circuit.*;

public class GridManager {
    private static final int GRID_SIZE = 40;
    public static int width = 0;
    public static int height = 0;
    public static int[][] grid = new int[width][height];

    public GridManager(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new int[width][height];
    }

    public static void placeComp(GridPoint pos, int code) {
        if(isFree(pos)) grid[(int) pos.x()][(int) pos.y()] = code;
    }

    public void removeComp(GridPoint pos) {
        if(isFree(pos)) { return; }

        grid[(int) pos.x()][(int) pos.y()] = 0;
    }

    private static boolean isFree(GridPoint pos) {
        return grid[(int) pos.x()][(int) pos.y()] == 0;
    }

    public int getComp(GridPoint pos) {
        if(isFree(pos)) { return 0; }

        return grid[(int) pos.x()][(int) pos.y()];
    }

    public int[][] getGrid() {
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
