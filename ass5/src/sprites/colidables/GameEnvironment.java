// ID: 320518020

package sprites.colidables;
import geometry.primitives.Line;
import geometry.primitives.Point;
import info.CollisionInfo;
import java.util.LinkedList;
import java.util.List;

/**
 * The type game.Game environment.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public class GameEnvironment {
    private List<Collidable> collidableList;

    /**
     * Instantiates a new game.Game environment.
     */
    public GameEnvironment() {
        this.collidableList = new LinkedList<>();
    }

    /**
     * Add the given collidable to the environment.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        this.collidableList.add(c);
    }

    /**
     * Remove collidable.
     *
     * @param c the collidable.
     */
    public void removeCollidable(Collidable c) {
        this.collidableList.remove(c);

    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory the trajectory
     * @return the closest collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Collidable closestObject = null;
        Point closestObjectPoint = null;
        for (Collidable object : this.collidableList) {
            //there is a collision
            if (object.getCollisionRectangle().intersectionPoints(trajectory).size() > 0) {
                if (closestObject == null) {
                    closestObject = object;
                    closestObjectPoint = trajectory.closestIntersectionToStartOfLine(object.getCollisionRectangle());
                }
                Point objectPoint = trajectory.closestIntersectionToStartOfLine(object.getCollisionRectangle());
                Point closestPoint = trajectory.closestIntersectionToStartOfLine(closestObject.getCollisionRectangle());
                //check if the collision is closer then before
                if (objectPoint.distance(trajectory.start()) < closestPoint.distance(trajectory.start())) {
                    closestObject = object;
                    closestObjectPoint = objectPoint;
                }
            }
        }
        if (closestObject == null) {
            return null;
        }
        return new CollisionInfo(closestObjectPoint, closestObject);
    }

    /**
     * Is stuck point.
     * Checks if a point is in a collidable.
     *
     * @param p the point, usually the center of a ball
     * @return the point
     */
    public Point isStuck(Point p) {
        for (Collidable object : this.collidableList) {
            if (object.getCollisionRectangle().isInsideRect(p)) {
                //incase collidable is the paddle
                if (object.getClass() == Paddle.class) {
                    return ((Paddle) object).movePointFromPaddle(p);
                }
                Point newPoint;
                //put the point near the collidable
                if (object.getCollisionRectangle().getTopLine().middle().getY() - 1 <= 0) {
                    newPoint = new Point(p.getX(),
                            object.getCollisionRectangle().getBottomLine().middle().getY() + 1);
                } else {
                    newPoint = new Point(p.getX(), object.getCollisionRectangle().getTopLine().middle().getY() - 1);
                }
                if (object.getCollisionRectangle().getLeftLine().middle().getY() - 1 <= 0) {
                    newPoint.setX(object.getCollisionRectangle().getRightLine().middle().getY() + 1);
                } else {
                    newPoint.setX(object.getCollisionRectangle().getLeftLine().middle().getY() - 1);
                }
                return newPoint;
            }
        }
        //incase not stuck
        return p;
    }
}