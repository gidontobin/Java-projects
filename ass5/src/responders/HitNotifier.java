// ID: 320518020

package responders;
import responders.listeners.HitListener;

/**
 * The interface Hit notifier.
 */
public interface HitNotifier {
    /**
     * Add hit listener to hit events.
     *
     * @param hl the hl
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hit listener from the list of responders.listeners to hit events.
     *
     * @param hl the hl
     */
    void removeHitListener(HitListener hl);
}
