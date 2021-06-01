// ID: 320518020

import java.util.List;

/**
 * The type Line.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public class Line {
    private static final double EPSILON = 1E-5;

    private Point start;
    private Point end;
    //Used for the equation: y=mx+b
    private double m;
    private double b;

    /**
     * Constructor.
     *
     * @param start the start
     * @param end   the end
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        if (this.start.getX() != this.end.getX()) {
            this.m = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
            this.b = this.start.getY() - this.m * this.start.getX();
        } else {
            //incase the x are the same, the slope and b are infinity
            this.m = Double.POSITIVE_INFINITY;
            this.b = Double.POSITIVE_INFINITY;
        }
    }

    /**
     * Constructor.
     *
     * @param x1 the x 1
     * @param y1 the y 1
     * @param x2 the x 2
     * @param y2 the y 2
     */
    public Line(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    /**
     * Length double.
     *
     * @return the length of the line
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Middle point.
     *
     * @return the middle point of the line.
     */
    public Point middle() {
        double x = (this.start.getX() + this.end.getX()) / 2;
        double y = (this.start.getY() + this.end.getY()) / 2;
        return new Point(x, y);
    }

    /**
     * Start point.
     *
     * @return the start point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * End point.
     *
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * Is intersecting boolean.
     *
     * @param other the other point
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        return this.intersectionWith(other) != null;
    }

    /**
     * Is point on line boolean.
     *
     * @param p the point
     * @return true if point is on the line, false otherwise
     */
    public boolean isPointOnLine(Point p) {
        return !((p.getX() < this.start.getX() && p.getX() < this.end.getX())
                || (p.getX() > this.start.getX() && p.getX() > this.end.getX())
                || (p.getY() < this.start.getY() && p.getY() < this.end.getY())
                || (p.getY() > this.start.getY() && p.getY() > this.end.getY()));
    }

    /**
     * Intersection with point.
     *
     * @param other the other
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        //incase the lines have the same slope, checks if there is only one point of intersection between the two
        if (Math.abs(this.m - other.m) < EPSILON || this.m == other.m) {
            if ((this.start.equals(other.end) && !this.isPointOnLine(other.start)
                    && !other.isPointOnLine(this.end)) || (this.start.equals(other.start)
                    && !this.isPointOnLine(other.end) && !other.isPointOnLine(this.end))) {
                return this.start;
            }
            if ((this.end.equals(other.end) && !this.isPointOnLine(other.start)
                    && !other.isPointOnLine(this.start)) || (this.end.equals(other.start)
                    && !this.isPointOnLine(other.end) && !other.isPointOnLine(this.start))) {
                return this.end;
            }
            if (this.start.equals(this.end) && other.isPointOnLine(this.start)) {
                return this.start;
            }
            if (other.start.equals(other.end) && this.isPointOnLine(other.start)) {
                return other.start;
            }
            return null;
        }
        //the lines dont have the same slope
        double x, y;
        if (this.m == Double.POSITIVE_INFINITY) {
            x = this.start.getX();
            y = other.m * x + other.b;
        } else if (other.m == Double.POSITIVE_INFINITY) {
            x = other.start.getX();
            y = this.m * x + this.b;
        } else {
            x = (this.b - other.b) / (other.m - this.m);
            y = this.m * x + this.b;
        }
        Point intersectionPoint = new Point(x, y);
        if (this.isPointOnLine(intersectionPoint) && other.isPointOnLine(intersectionPoint)) {
            return intersectionPoint;
        }
        return null;
    }

    /**
     * Equals boolean.
     *
     * @param other the other
     * @return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        return false;
    }

    /**
     * Closest intersection to start of line point.
     *
     * @param rect the rect
     * @return null, if this line does not intersect with the rectangle.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //get all intersection points with this line and rect
        List<Point> pointList = rect.intersectionPoints(this);
        if (pointList.size() == 0) {
            return null;
        }
        //check witch point is closest
        Point closest = this.end;
        for (Point intersect : pointList) {
            if (intersect.distance(this.start) < closest.distance(this.start)) {
                closest = intersect;
            }
        }
        return closest;
    }
}