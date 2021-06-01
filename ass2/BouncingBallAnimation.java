// ID: 320518020

import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * The type Bouncing ball animation.
 */
public class BouncingBallAnimation {
    private static final int SCREEN_WIDTH = 200;
    private static final int SCREEN_HEIGHT = 200;
    private static final int SLEEP_TIME = 50;
    private static final int RADIOS = 30;


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        if (args.length == 4) {
            Point start = new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            drawAnimation(start, Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } else {
            System.out.println("Error! number of args incorrect");
        }
    }

    /**
     * The method will draw an animation of a ball bouncing
     * around the screen.
     *
     * @param start the starting point
     * @param dx    the dx of the velocity
     * @param dy    the dy of the velocity
     */
    private static void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("title", SCREEN_WIDTH, SCREEN_HEIGHT);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        Ball ball = new Ball(start, RADIOS, java.awt.Color.BLACK, SCREEN_WIDTH, SCREEN_HEIGHT);
        ball.setVelocity(dx, dy);
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(SLEEP_TIME);
        }

    }
}