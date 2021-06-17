package sprites;

import biuoop.DrawSurface;
import geometry.primitives.Line;

import java.awt.Color;

/**
 * The type Line draw.
 */
public class LineDraw implements Sprite {
    private Line line;
    private Color color;

    /**
     * Instantiates a new Line draw.
     *
     * @param line  the line
     * @param color the color
     */
    public LineDraw(Line line, Color color) {
        this.line = line;
        this.color = color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawLine((int) this.line.start().getX(), (int) this.line.start().getY(), (int) this.line.end().getX(),
                (int) this.line.end().getY());
    }

    @Override
    public void timePassed() {

    }
}
