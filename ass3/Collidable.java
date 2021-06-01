// ID: 320518020

/**
 * The interface Collidable.
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
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Point collisionPoint, Velocity currentVelocity);
}
