// ID: 320518020

package sprites.colidables;
import geometry.primitives.Point;
import geometry.primitives.Rectangle;
import physics.Velocity;
import sprites.Ball;

/**
 * The interface sprites.colidables.Collidable.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public interface Collidable {
    /**
     * Gets collision rectangle.
     *
     * @return the the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     *
     * @param hitter          the hitter
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
