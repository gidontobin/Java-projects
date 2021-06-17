// ID: 320518020

package sprites;
import biuoop.DrawSurface;
import java.util.LinkedList;
import java.util.List;

/**
 * The type sprites.Sprite collection.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public class SpriteCollection {
    private List<Sprite> spriteCollection;

    /**
     * Instantiates a new sprites.Sprite collection.
     */
    public SpriteCollection() {
        this.spriteCollection = new LinkedList<>();
    }

    /**
     * Add sprite.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        this.spriteCollection.add(s);
    }

    /**
     * Remove sprite.
     *
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        this.spriteCollection.set(this.spriteCollection.indexOf(s), null);
    }

    /**
     * Notify all sprites time passed.
     */
    public void notifyAllTimePassed() {
        for (Sprite s : this.spriteCollection) {
            if (s != null) {
                s.timePassed();
            }
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d the drawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.spriteCollection) {
            if (s != null) {
                s.drawOn(d);
            }
        }
    }
}