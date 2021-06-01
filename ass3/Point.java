// ID: 320518020

/**
 * The type Point.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public class Point {
    private static final double EPSILON = 1E-5;

    private double x;
    private double y;

    /**
     * Constructor.
     *
     * @param x the x
     * @param y the y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;

    }

    /**
     * Distance - return the distance of this point to the other point.
     *
     * @param other the other
     * @return the double
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow((other.x - this.x), 2) + Math.pow((other.y - this.y), 2));
    }

    /**
     * Equals.
     *
     * @param other the other
     * @return true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        if (Math.abs(other.x - this.x) < EPSILON && Math.abs(this.y - other.y) < EPSILON) {
            return true;
        }
        return false;
    }

    /**
     * Gets x.
     *
     * @return the x of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets y.
     *
     * @return the y of this point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * Sets x.
     *
     * @param newX the new x
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /**
     * Sets y.
     *
     * @param newY the new y
     */
    public void setY(double newY) {
        this.y = newY;
    }
}


