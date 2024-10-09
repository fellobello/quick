package utils;

import javafx.geometry.Point2D;

public class GridPoint {
    private final double x;
    private final double y;

    public GridPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point2D toPoint2D() {
        return new Point2D(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GridPoint)) return false;
        GridPoint other = (GridPoint) obj;
        return Double.compare(this.x, other.x) == 0 && Double.compare(this.y, other.y) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);
        return result;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double distanceTo(GridPoint other) {
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }
}
