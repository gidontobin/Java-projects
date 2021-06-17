package sprites;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Name of level.
 */
public class NameOfLevel implements Sprite {
    private String levelName;

    /**
     * Instantiates a new Name of level.
     *
     * @param levelName the level name
     */
    public NameOfLevel(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(550, 19, "Level Name:" + this.levelName, 20);
    }

    @Override
    public void timePassed() {
    }
}
