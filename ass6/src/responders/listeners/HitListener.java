// ID: 320518020

package responders.listeners;
import sprites.Ball;
import sprites.colidables.Block;

/**
 * The interface Hit listener.
 */
public interface HitListener {
    /**
     * Hit event.
     * <p>
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the sprites.Ball that's doing the hitting.
     *
     * @param beingHit the being hit
     * @param hitter   the hitter
     */
    void hitEvent(Block beingHit, Ball hitter);
}