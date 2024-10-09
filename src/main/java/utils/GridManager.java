package utils;
import tools.*;

public class GridManager {
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
        grid[(int) pos.getX()][(int) pos.getY()] = tool;

        return true;
    }

    public void removeComponent(GridPoint pos) {
        if(!isOccupied(pos)) { return; }

        grid[(int) pos.getX()][(int) pos.getY()] = null;
    }

    public boolean isOccupied(GridPoint pos) {
        return grid[(int) pos.getX()][(int) pos.getY()] != null;
    }

    public Tool getComp(GridPoint pos) {
        if(!isOccupied(pos)) { return null; }

        return grid[(int) pos.getX()][(int) pos.getY()];
    }

    public Tool[][] getGrid() {
        return grid;
    }
}
