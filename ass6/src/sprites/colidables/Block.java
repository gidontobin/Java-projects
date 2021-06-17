// ID: 320518020

package sprites.colidables;
import biuoop.DrawSurface;
import game.GameLevel;
import geometry.primitives.Point;
import geometry.primitives.Rectangle;
import physics.Velocity;
import responders.HitNotifier;
import responders.listeners.HitListener;
import sprites.Ball;
import sprites.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Block.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private boolean collided;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    /**
     * Instantiates a new sprites.colidables.Block.
     *
     * @param rect  the rectangle
     * @param color the color
     */
    public Block(Rectangle rect, java.awt.Color color) {
        this.rect = rect;
        this.collided = false;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Instantiates a new sprites.colidables.Block.
     *
     * @param rect the rectangle
     */
    public Block(Rectangle rect) {
        this(rect, null);
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
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
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
        this.notifyHit(hitter);
        return newVelocity;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        if (this.color == null) {
            return;
        }
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
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * Remove from game.
     *
     * @param g the game
     */
    public void removeFromGame(GameLevel g) {
        g.removeCollidable(this);
        g.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);

    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);

    }

    /**
     * Notify hit.
     *
     * @param hitter the ball that hit
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all responders.listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}