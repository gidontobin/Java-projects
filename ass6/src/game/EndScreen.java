package game;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import responders.Counter;
import java.awt.Color;

/**
 * The type End screen.
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;
    private String s;

    /**
     * Instantiates a new End screen.
     *
     * @param k     the k
     * @param score the score
     * @param s     the s
     */
    public EndScreen(KeyboardSensor k, Counter score, String s) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
        this.s = s;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.WHITE);
        d.drawText(100, d.getHeight() / 2, this.s + this.score.getValue(), 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
