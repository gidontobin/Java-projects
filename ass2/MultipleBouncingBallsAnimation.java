// ID: 320518020

import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;
import java.util.Random;

/**
 * The type Multiple bouncing balls animation.
 */
public class MultipleBouncingBallsAnimation {
    private static final int SCREEN_WIDTH = 200;
    private static final int SCREEN_HEIGHT = 200;
    private static final int SLEEP_TIME = 50;
    private static final int MAX_DEGREE = 360;
    private static final int MAX_SPEED = 300;
    private static final int MIN_SPEED = 50;
    private static final int MAX_COLOR = 255;
    private static final int MAX_SIZE_SPEED = 50;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        if (args == null) {
            return;
        }
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        GUI gui = new GUI("title", SCREEN_WIDTH, SCREEN_HEIGHT);
        Ball[] ballsArr = makeBalls(args, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            for (Ball aBall : ballsArr) {
                aBall.moveOneStep();
                aBall.drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(SLEEP_TIME);
        }
    }

    /**
     * Make an array of random balls, and returns the array.
     *
     * @param args               the args
     * @param startWidthOfFrame  the start width of frame
     * @param startHeightOfFrame the start height of frame
     * @param widthOfFrame       the width of frame
     * @param heightOfFrame      the height of frame
     * @return the ball [ ], an array of random balls
     */
    public static Ball[] makeBalls(String[] args, int startWidthOfFrame,
                                   int startHeightOfFrame, int widthOfFrame, int heightOfFrame) {
        Random rand = new Random();
        Ball[] arrBalls = new Ball[args.length];
        int randSpeed = rand.nextInt(MAX_SPEED) + MIN_SPEED;
        //making a ball
        for (int i = 0; i < arrBalls.length; i++) {
            int red = rand.nextInt(MAX_COLOR);
            int green = rand.nextInt(MAX_COLOR);
            int blue = rand.nextInt(MAX_COLOR);
            Color randomColor = new Color(red, green, blue);
            int size = Integer.parseInt(args[i]);
            if (size * 2 >= Math.min(widthOfFrame, heightOfFrame)) {
                size = Math.min(widthOfFrame, heightOfFrame) / 2 - 2;
            }
            arrBalls[i] = new Ball(rand.nextInt(widthOfFrame - size * 2) + size + startWidthOfFrame,
                    rand.nextInt(heightOfFrame - size * 2) + size + startHeightOfFrame,
                    size, randomColor, widthOfFrame, heightOfFrame);
            arrBalls[i].setStartWidthHeightOfFrame(startWidthOfFrame, startHeightOfFrame);
            if (size >= MAX_SIZE_SPEED) {
                size = MAX_SIZE_SPEED;
            }
            Velocity v = Velocity.fromAngleAndSpeed(rand.nextInt(MAX_DEGREE),
                    (double) randSpeed / size);
            arrBalls[i].setVelocity(v);
        }
        return arrBalls;
    }
}