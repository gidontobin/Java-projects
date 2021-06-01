// ID: 320518020

import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.Random;
import java.awt.Color;

/**
 * The type Abstract art drawing.
 */
public class AbstractArtDrawing {
    private static final int AMOUNT_OF_LINES = 10;
    private static final int SCREEN_WIDTH = 400;
    private static final int SCREEN_HEIGHT = 300;
    private static final int CIRCLE_SIZE = 3;

    /**
     * Draw random lines.
     * Create a window with the title "Random Lines"
     * which is 400 pixels wide and 300 pixels high.
     */
    public void drawRandomLines() {
        GUI gui = new GUI("Random Lines", SCREEN_WIDTH, SCREEN_HEIGHT);
        DrawSurface d = gui.getDrawSurface();
        Line[] arrLine = new Line[AMOUNT_OF_LINES];
        for (int i = 0; i < AMOUNT_OF_LINES; ++i) {
            Line l = generateRandomLine();
            drawLine(l, d);
            arrLine[i] = l;
            d.setColor(Color.BLUE);
            d.fillCircle((int) l.middle().getX(), (int) l.middle().getY(), CIRCLE_SIZE);
            for (int j = 0; j < i; ++j) {
                if (arrLine[j].isIntersecting(l)) {
                    Point interPoint = arrLine[j].intersectionWith(l);
                    d.setColor(Color.RED);
                    d.fillCircle((int) interPoint.getX(), (int) interPoint.getY(), CIRCLE_SIZE);
                }
            }
        }
        gui.show(d);
    }

    /**
     * Generate random line line.
     *
     * @return the line
     */
    public Line generateRandomLine() {
        Random rand = new Random();
        return new Line(rand.nextInt(SCREEN_WIDTH), rand.nextInt(SCREEN_HEIGHT),
                rand.nextInt(SCREEN_WIDTH), rand.nextInt(SCREEN_HEIGHT));
    }

    /**
     * Draw line.
     *
     * @param l the line
     * @param d the drawSurface
     */
    public void drawLine(Line l, DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawLine((int) l.start().getX(), (int) l.start().getY(), (int) l.end().getX(), (int) l.end().getY());
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        AbstractArtDrawing example = new AbstractArtDrawing();
        example.drawRandomLines();
    }
}