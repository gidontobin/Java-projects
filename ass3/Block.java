// ID: 320518020

import biuoop.DrawSurface;
import java.awt.Color;
/**
 * The type Block.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public class Block implements Collidable, Sprite {
    private Rectangle rect;
    private boolean collided;
    private java.awt.Color color;

    /**
     * Instantiates a new Block.
     *
     * @param rect  the rectangle
     * @param color the color
     */
    public Block(Rectangle rect, java.awt.Color color) {
        this.rect = rect;
        this.collided = false;
        this.color = color;
    }

    /**
     * Instantiates a new Block.
     *
     * @param rect the rectangle
     */
    public Block(Rectangle rect) {
        this(rect, Color.BLACK);
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return new Rectangle(this.rect.getUpperLeft(), this.rect.getWidth(), this.rect.getHeight());
    }

    /**
     * Sets collision rectangle.
     *
     * @param newRect the new rectangle
     */
    public void setCollisionRectangle(Rectangle newRect) {
        this.rect = newRect;
    }

    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        if (this.rect.getTopLine().isPointOnLine(collisionPoint)
                || this.rect.getBottomLine().isPointOnLine(collisionPoint)) {
            newVelocity.setDy(-newVelocity.getDy());
        }
        if (this.rect.getLeftLine().isPointOnLine(collisionPoint)
                || this.rect.getRightLine().isPointOnLine(collisionPoint)) {
            newVelocity.setDx(-newVelocity.getDx());
        }
        this.collided = true;
        return newVelocity;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(), (int) this.getCollisionRectangle().getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(), (int) this.getCollisionRectangle().getHeight());
    }

    @Override
    public void timePassed() {
    }

    /**
     * Add to game.
     *
     * @param g the game
     */
    public void addToGame(Game g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * Remove from game.
     *
     * @param g the game
     */
    public void removeFromGame(Game g) {
        g.removeCollidable(this);
        g.removeSprite(this);
    }

}