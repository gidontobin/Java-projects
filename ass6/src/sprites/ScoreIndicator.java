// ID: 320518020

package sprites;
import biuoop.DrawSurface;
import responders.Counter;
import java.awt.Color;

/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    private Counter currentScore;

    /**
     * Instantiates a new Score indicator.
     *
     * @param score the score
     */
    public ScoreIndicator(Counter score) {
        this.currentScore = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.lightGray);
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(Color.black);
        d.drawText(400, 19, "Score:" + this.currentScore.getValue(), 20);

    }

    @Override
    public void timePassed() {

    }
}
