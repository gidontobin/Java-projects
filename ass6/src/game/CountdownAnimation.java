package game;

import biuoop.DrawSurface;
import sprites.SpriteCollection;
import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */

public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private double numOfMilSecondsPerNum;
    private double numOfMilSecondsPerNumFinal;
    private int countFrom;
    private SpriteCollection gameScreen;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.numOfMilSecondsPerNum = (numOfSeconds * 60) / (countFrom + 1);
        this.numOfMilSecondsPerNumFinal = this.numOfMilSecondsPerNum;


    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.fillRectangle(0, 0, 800, 600);
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.BLUE);
        d.drawText(350, d.getHeight() / 2, "" + this.countFrom, 200);
        this.numOfMilSecondsPerNum--;
        if (this.numOfMilSecondsPerNum < 0) {
            this.countFrom--;
            this.numOfMilSecondsPerNum = this.numOfMilSecondsPerNumFinal;
        }
    }

    @Override
    public boolean shouldStop() {
        if (this.countFrom < 0) {
            return true;
        }
        return false;
    }

}