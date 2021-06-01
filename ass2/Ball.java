// ID: 320518020

import biuoop.DrawSurface;

/**
 * The type Ball.
 */
public class Ball {
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity v;
    private int startWidthOfFrame;
    private int startHeightOfFrame;
    private int widthOfFrame;
    private int heightOfFrame;

    /**
     * Constructor.
     *
     * @param center      the center
     * @param r           the radios
     * @param color       the color
     * @param width       the width
     * @param height      the height
     * @param startWidth  the start width
     * @param startHeight the start height
     */
    public Ball(Point center, int r, java.awt.Color color, int width, int height, int startWidth, int startHeight) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.widthOfFrame = width;
        this.heightOfFrame = height;
        this.startWidthOfFrame = startWidth;
        this.startHeightOfFrame = startHeight;

    }

    /**
     * Constructor.
     *
     * @param center the center
     * @param r      the radios
     * @param color  the color
     * @param width  the width
     * @param height the height
     */
    public Ball(Point center, int r, java.awt.Color color, int width, int height) {
        this(center, r, color, width, height, 0, 0);
    }

    /**
     * Constructor.
     *
     * @param x     the x of the center
     * @param y     the y of the center
     * @param r     the radios
     * @param color the color
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this(new Point(x, y), r, color);
    }

    /**
     * Constructor.
     *
     * @param x      the x of the center
     * @param y      the y of the center
     * @param r      the radios
     * @param color  the color
     * @param width  the width
     * @param height the height
     */
    public Ball(double x, double y, int r, java.awt.Color color, int width, int height) {
        this(new Point(x, y), r, color, width, height);
    }

    /**
     * Constructor.
     *
     * @param center the center
     * @param r      the radios
     * @param color  the color
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this(center, r, color, 200, 200);
    }

    /**
     * Gets x.
     *
     * @return the x of the center
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Gets y.
     *
     * @return the y of the center
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Gets size.
     *
     * @return the radios
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Gets width of frame.
     *
     * @return the width of frame
     */
    public int getWidthOfFrame() {
        return this.widthOfFrame;
    }

    /**
     * Gets height of frame.
     *
     * @return the height of frame
     */
    public int getHeightOfFrame() {
        return this.heightOfFrame;
    }

    /**
     * Gets start width of frame.
     *
     * @return the start width of frame
     */
    public int getStartWidthOfFrame() {
        return this.startWidthOfFrame;
    }

    /**
     * Gets start height of frame.
     *
     * @return the start height of frame
     */
    public int getStartHeightOfFrame() {
        return this.startHeightOfFrame;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * Sets start width height of frame.
     *
     * @param startWidth  the start width
     * @param startHeight the start height
     */
    public void setStartWidthHeightOfFrame(int startWidth, int startHeight) {
        this.startWidthOfFrame = startWidth;
        this.startHeightOfFrame = startHeight;
    }

    /**
     * Sets velocity.
     *
     * @param velocity the velocity
     */
    public void setVelocity(Velocity velocity) {
        this.v = velocity;
    }

    /**
     * Sets velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * Sets size of frame.
     *
     * @param width  the width
     * @param height the height
     */
    public void setSizeOfFrame(int width, int height) {
        this.widthOfFrame = width;
        this.heightOfFrame = height;
    }

    /**
     * Draw the ball on the given DrawSurface.
     *
     * @param surface the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
    }

    /**
     * Move one step.
     */
    public void moveOneStep() {
        //checking if ball coordinates are in boundaries, if not - replacing them to be in
        if (center.getX() - radius < startWidthOfFrame) {
            center.setX(startWidthOfFrame + radius);
        }
        if (center.getX() + radius > startWidthOfFrame + widthOfFrame) {
            center.setX(startWidthOfFrame + widthOfFrame - radius);
        }
        if (center.getY() - radius < startHeightOfFrame) {
            center.setY(startHeightOfFrame + radius);
        }
        if (center.getY() + radius > startHeightOfFrame + heightOfFrame) {
            center.setY(startHeightOfFrame + heightOfFrame - radius);
        }
        //check if got to end of width, if so - change direction
        if (this.center.getX() + this.v.getDx() + this.getSize() >= this.widthOfFrame + this.startWidthOfFrame
                || this.center.getX() + this.v.getDx() - this.getSize() <= this.startWidthOfFrame) {
            this.v.setDx(-this.v.getDx());
        }
        //check if got to end of height, if so - change direction
        if (this.center.getY() + this.v.getDy() + this.getSize() >= this.heightOfFrame + this.startHeightOfFrame
                || this.center.getY() + this.v.getDy() - this.getSize() <= this.startHeightOfFrame) {
            this.v.setDy(-this.v.getDy());
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }
}
