package sprites.colidables;

import biuoop.DrawSurface;
import sprites.Sprite;

import java.util.List;

/**
 * The type Backround.
 */
public class Backround implements Sprite {
    private List<Sprite> spriteList;

    /**
     * Instantiates a new Backround.
     *
     * @param spriteList the sprite list
     */
    public Backround(List<Sprite> spriteList) {
        this.spriteList = spriteList;

    }

    @Override
    public void drawOn(DrawSurface surface) {
        for (Sprite s : this.spriteList) {
            s.drawOn(surface);
        }
    }

    @Override
    public void timePassed() {
    }
}
