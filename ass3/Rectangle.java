// ID: 320518020

import java.util.ArrayList;
import java.util.List;

/**
 * The type Rectangle.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft the upper left point
     * @param width     the width
     * @param height    the height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Intersection points java . util . list.
     *
     * @param line the line
     * @return a (possibly empty) List of intersection points
     * with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> pointList = new ArrayList<>();
        Point topIntersection = line.intersectionWith(this.getTopLine());
        Point bottomIntersection = line.intersectionWith(this.getBottomLine());
        Point leftIntersection = line.intersectionWith(this.getLeftLine());
        Point rightIntersection = line.intersectionWith(this.getRightLine());
        if (topIntersection != null) {
            pointList.add(topIntersection);
        }
        if (bottomIntersection != null) {
            pointList.add(bottomIntersection);
        }
        if (leftIntersection != null) {
            pointList.add(leftIntersection);
        }
        if (rightIntersection != null) {
            pointList.add(rightIntersection);
        }
        return pointList;
    }

    /**
     * Gets width.
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height.
     *
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets upper left.
     *
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY());
    }

    /**
     * Gets top line.
     *
     * @return the top line
     */
    public Line getTopLine() {
        return new Line(this.upperLeft, new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY()));
    }

    /**
     * Gets bottom line.
     *
     * @return the bottom line
     */
    public Line getBottomLine() {
        return new Line(this.upperLeft.getX(), this.upperLeft.getY() + this.height,
                this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
    }

    /**
     * Gets left line.
     *
     * @return the left line
     */
    public Line getLeftLine() {
        return new Line(this.upperLeft, new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height));
    }

    /**
     * Gets right line.
     *
     * @return the right line
     */
    public Line getRightLine() {
        return new Line(this.upperLeft.getX() + this.width, this.upperLeft.getY(),
                this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
    }

    /**
     * Is inside rect boolean.
     *
     * @param point the point
     * @return the boolean
     */
    public boolean isInsideRect(Point point) {
        return point.getX() >= this.getUpperLeft().getX()
                && point.getX() <= this.getUpperLeft().getX() + this.width
                && point.getY() >= this.getUpperLeft().getY()
                && point.getY() <= this.getUpperLeft().getY() + this.height;
    }

}
