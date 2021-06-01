// ID: 320518020

import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;

/**
 * The type Multiple frames bouncing balls animation.
 */
public class MultipleFramesBouncingBallsAnimation {
    private static final int SCREEN_WIDTH = 700;
    private static final int SCREEN_HEIGHT = 700;
    private static final int SLEEP_TIME = 50;
    private static final int GREY_START = 50;
    private static final int GREY_SQURE = 450;
    private static final int YELLOW_START = 450;
    private static final int YELLOW_SQURE = 150;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI("title", SCREEN_WIDTH, SCREEN_HEIGHT);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        String[] argsA = new String[(args.length + 1) / 2];
        String[] argsB = new String[args.length - argsA.length];
        for (int i = 0; i < args.length; i++) {
            if (i < argsA.length) {
                argsA[i] = args[i];
            } else {
                argsB[i - argsA.length] = args[i];
            }
        }
        Ball[] arrBall1 = MultipleBouncingBallsAnimation.makeBalls(argsA, GREY_START, GREY_START,
                GREY_SQURE, GREY_SQURE);
        Ball[] arrBall2 = MultipleBouncingBallsAnimation.makeBalls(argsB, YELLOW_START, YELLOW_START,
                YELLOW_SQURE, YELLOW_SQURE);
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            d.setColor(Color.gray);
            d.fillRectangle(GREY_START, GREY_START, GREY_SQURE, GREY_SQURE);
            for (int i = 0; i < arrBall1.length; i++) {
                arrBall1[i].moveOneStep();
                arrBall1[i].drawOn(d);
            }
            d.setColor(Color.yellow);
            d.fillRectangle(YELLOW_START, YELLOW_START, YELLOW_SQURE, YELLOW_SQURE);
            for (int i = 0; i < arrBall2.length; i++) {
                arrBall2[i].moveOneStep();
                arrBall2[i].drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(SLEEP_TIME);
        }
    }

}
