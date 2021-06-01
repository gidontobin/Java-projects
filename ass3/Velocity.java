// ID: 320518020

/**
 * The type Velocity.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Constructor.
     *
     * @param theDx the the dx
     * @param theDy the the dy
     */
    public Velocity(double theDx, double theDy) {
        this.dx = theDx;
        this.dy = theDy;
    }

    /**
     * From angle and speed velocity.
     *
     * @param angle the angle
     * @param speed the speed
     * @return the velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * (Math.sin(Math.toRadians(angle)));
        double dy = -speed * (Math.cos(Math.toRadians(angle)));
        return new Velocity(dx, dy);
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public double getSpeed() {
        return Math.sqrt(Math.pow(this.dx, 2) + Math.pow(this.dy, 2));
    }

    /**
     * Sets dx.
     *
     * @param theDx the dx
     */
    public void setDx(double theDx) {
        this.dx = theDx;
    }

    /**
     * Sets dy.
     *
     * @param theDy the dy
     */
    public void setDy(double theDy) {
        this.dy = theDy;
    }

    /**
     * Gets dx.
     *
     * @return the dx
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Gets dy.
     *
     * @return the dy
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Apply to point point.
     *
     * @param p a point with position (x,y)
     * @return a new point with position (x+dx, y+dy)
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, (p.getY() + this.dy));
    }
}