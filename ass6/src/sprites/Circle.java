package sprites;
import biuoop.DrawSurface;
import geometry.primitives.Point;
import java.awt.Color;


/**
 * The type Circle.
 */
public class Circle implements Sprite {
    private Point center;
    private int radius;
    private Color inside;
    private Color outside;

    /**
     * Instantiates a new Circle.
     *
     * @param p       the p
     * @param radius  the radius
     * @param inside  the inside
     * @param outside the outside
     */
    public Circle(Point p, int radius, Color inside, Color outside) {
        this.center = p;
        this.radius = radius;
        this.inside = inside;
        this.outside = outside;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.inside);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
        surface.setColor(this.outside);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
    }

    @Override
    public void timePassed() {
    }
}
