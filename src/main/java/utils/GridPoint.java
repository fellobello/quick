package utils;

public class GridPoint {
    private final int xInd;
    private final int yInd;

    public GridPoint(int xInd, int yInd) {
        this.xInd = xInd;
        this.yInd = yInd;
    }

    static GridPoint createGridPoint(int xInd, int yInd) {
        return new GridPoint(xInd, yInd);
    }

    public int getXIndex() {
        return xInd;
    }

    public int getYIndex() {
        return yInd;
    }

    public double getX() {
        return xInd * GridManager.GRID_SIZE;
    }

    public double getY() {
        return yInd * GridManager.GRID_SIZE;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GridPoint)) return false;
        GridPoint other = (GridPoint) obj;
        return this.xInd == other.xInd && this.yInd == other.yInd;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(xInd);
        result = 31 * result + Integer.hashCode(yInd);
        return result;
    }

    @Override
    public String toString() {
        return "GridPoint: (" + xInd + ", " + yInd + ")";
    }
}
