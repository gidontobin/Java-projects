// ID: 320518020

package sprites;
import biuoop.DrawSurface;
import game.Game;
import geometry.primitives.Line;
import geometry.primitives.Point;
import info.CollisionInfo;
import physics.Velocity;
import sprites.colidables.GameEnvironment;

import java.awt.Color;

/**
 * The type sprites.Ball.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public class Ball implements Sprite {
    private static final double EPSILON = 1E-5;
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity v;
    private GameEnvironment gameEnvironment;

    /**
     * Constructor.
     *
     * @param center the center
     * @param r      the radios
     * @param color  the color
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.v = new Velocity(1, 1);
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
     * Sets game environment.
     *
     * @param g the g
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.gameEnvironment = g;
    }

    /**
     * Draw the ball on the given DrawSurface.
     *
     * @param surface the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
        surface.setColor(Color.black);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
    }
    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * Move one step.
     */
    public void moveOneStep() {
        int moveByOneY = -1, moveByOneX = -1;
        if (this.v.getDx() < 0) {
            moveByOneX = 1;
        }
        if (this.v.getDy() < 0) {
            moveByOneY = 1;
        }
        //check if there is a collision
        CollisionInfo info = this.gameEnvironment.getClosestCollision(new Line(this.center, new Point(
                this.center.getX() + this.v.getDx() - this.radius * moveByOneX,
                this.center.getY() + this.v.getDy() - this.radius * moveByOneY)));
        if (info == null) {
            Point newCenter = this.getVelocity().applyToPoint(this.center);
            newCenter = this.gameEnvironment.isStuck(newCenter);
            this.center = newCenter;
            return;
        }
        Velocity newV = info.collisionObject().hit(this, info.collisionPoint(), this.v);
        //move ball close to collision point
        if (this.v.getDx() != newV.getDx()) {
            this.center.setX(info.collisionPoint().getX() + moveByOneX);
        }
        if (this.v.getDy() != newV.getDy()) {
            this.center.setY(info.collisionPoint().getY() + moveByOneY);
        }
        this.v = newV;
        Point newCenter = this.getVelocity().applyToPoint(this.center);
        //check if center in a block
        newCenter = this.gameEnvironment.isStuck(newCenter);
        this.center = newCenter;
    }

    /**
     * Add the ball to game.
     *
     * @param g the game
     */
    public void addToGame(Game g) {
        g.addSprite(this);
        this.gameEnvironment = g.getGameEnvironment();
    }

    /**
     * Remove from game.
     *
     * @param g the g
     */
    public void removeFromGame(Game g) {
        g.removeSprite(this);
        this.gameEnvironment = g.getGameEnvironment();
    }
}
