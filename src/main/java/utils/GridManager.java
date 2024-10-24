package utils;

import java.util.HashMap;
import java.util.Map;

public class GridManager {
    public static final int GRID_SIZE = 40;
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private static final int GRID_WIDTH = CANVAS_WIDTH / GRID_SIZE;
    private static final int GRID_HEIGHT = CANVAS_HEIGHT / GRID_SIZE;

    private static int[][] grid = new int[GRID_WIDTH][GRID_HEIGHT];
    private static Map<String, GridPoint> gridPointsCache = new HashMap<>();  // Cache to store GridPoint instances

    private static GridManager instance;

    public GridManager() {
        // Initialize grid if necessary
    }

    public static GridManager getInstance() {
        if (instance == null) {
            instance = new GridManager();
        }
        return instance;
    }

    public static GridPoint getGridPoint(int xInd, int yInd) {
        String key = xInd + "," + yInd;
        return gridPointsCache.computeIfAbsent(key, k -> GridPoint.createGridPoint(xInd, yInd));
    }

    public static GridPoint snapToGrid(double x, double y) {
        int xInd = (int) Math.round(x / GRID_SIZE);
        int yInd = (int) Math.round(y / GRID_SIZE);
        return getGridPoint(xInd, yInd);
    }

    public static void placeComp(GridPoint pos, int code) {
        grid[pos.getXIndex()][pos.getYIndex()] = code;
    }

    public void removeComp(GridPoint pos) {
        grid[pos.getXIndex()][pos.getYIndex()] = 0;
    }

    public boolean isFree(GridPoint pos) {
        return grid[pos.getXIndex()][pos.getYIndex()] == 0;
    }

    public int getComp(GridPoint pos) {
        return grid[pos.getXIndex()][pos.getYIndex()];
    }

    public int[][] getGrid() {
        return grid;
    }
}