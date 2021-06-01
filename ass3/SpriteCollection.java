// ID: 320518020

import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Sprite collection.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public class SpriteCollection {
    private List<Sprite> spriteCollection;

    /**
     * Instantiates a new Sprite collection.
     */
    public SpriteCollection() {
        this.spriteCollection = new ArrayList<>();
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
        this.spriteCollection.remove(s);
    }

    /**
     * Notify all sprites time passed.
     */
    public void notifyAllTimePassed() {
        for (Sprite s : this.spriteCollection) {
            s.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d the drawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.spriteCollection) {
            s.drawOn(d);
        }
    }
}