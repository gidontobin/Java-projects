// ID: 320518020

package sprites;
import biuoop.DrawSurface;

/**
 * The interface sprites.Sprite.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public interface Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d the drawSurface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}
