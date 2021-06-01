// ID: 320518020

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The type Game.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public class Game {
    private static final double SPEED = 5;
    private static final int WIDTH_OF_SCREEN = 800;
    private static final int HEIGHT_OF_SCREEN = 600;
    private static final int BORDER_SIZE = 20;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private biuoop.KeyboardSensor keyboard;
    private Paddle paddle;

    /**
     * Instantiates a new Game.
     */
    public Game() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
    }

    /**
     * Gets game environment.
     *
     * @return the game environment
     */
    public GameEnvironment getGameEnvironment() {
        return this.environment;
    }

    /**
     * Add collidable.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Add sprite.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Remove collidable.
     *
     * @param c the collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Remove sprite.
     *
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        this.gui = new GUI("title", WIDTH_OF_SCREEN, HEIGHT_OF_SCREEN);
        this.keyboard = this.gui.getKeyboardSensor();
        Ball ball1 = new Ball(new Point(400, 500), 8, Color.white);
        ball1.setVelocity(Velocity.fromAngleAndSpeed(180, SPEED));
        ball1.addToGame(this);
        Ball ball2 = new Ball(new Point(400, 400), 8, Color.ORANGE);
        ball2.setVelocity(Velocity.fromAngleAndSpeed(180, SPEED));
        ball2.addToGame(this);
        this.paddle = new Paddle(
                new Block(new Rectangle(new Point(400, 560), 80, 20), Color.YELLOW), SPEED,
                BORDER_SIZE, WIDTH_OF_SCREEN - BORDER_SIZE);
        this.paddle.addToGame(this);
        //make and add border blocks
        Block top = new Block(new Rectangle(new Point(0, 0), WIDTH_OF_SCREEN, BORDER_SIZE), Color.GRAY);
        Block left = new Block(new Rectangle(new Point(0, 0), BORDER_SIZE, HEIGHT_OF_SCREEN), Color.GRAY);
        Block bottom = new Block(new Rectangle(new Point(0, HEIGHT_OF_SCREEN - BORDER_SIZE), WIDTH_OF_SCREEN,
                BORDER_SIZE), Color.GRAY);
        Block right = new Block(new Rectangle(new Point(WIDTH_OF_SCREEN - BORDER_SIZE, 0), BORDER_SIZE,
                HEIGHT_OF_SCREEN), Color.GRAY);
        top.addToGame(this);
        bottom.addToGame(this);
        left.addToGame(this);
        right.addToGame(this);
        //make and add game blocks
        for (int i = 730; i > 130; i -= 50) {
            Block block = new Block(new Rectangle(new Point(i, 100), 50, 25), Color.RED);
            block.addToGame(this);
        }
        for (int i = 730; i > 180; i -= 50) {
            Block block = new Block(new Rectangle(new Point(i, 125), 50, 25), Color.GREEN);
            block.addToGame(this);
        }
        for (int i = 730; i > 230; i -= 50) {
            Block block = new Block(new Rectangle(new Point(i, 150), 50, 25), Color.PINK);
            block.addToGame(this);
        }
        for (int i = 730; i > 280; i -= 50) {
            Block block = new Block(new Rectangle(new Point(i, 175), 50, 25), Color.cyan);
            block.addToGame(this);
        }
        for (int i = 730; i > 330; i -= 50) {
            Block block = new Block(new Rectangle(new Point(i, 200), 50, 25), Color.magenta);
            block.addToGame(this);
        }
        for (int i = 730; i > 380; i -= 50) {
            Block block = new Block(new Rectangle(new Point(i, 225), 50, 25), Color.darkGray);
            block.addToGame(this);
        }
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (true) {
            long startTime = System.currentTimeMillis(); // timing

            DrawSurface d = this.gui.getDrawSurface();
            d.setColor(Color.BLUE);
            d.fillRectangle(0, 0, WIDTH_OF_SCREEN, HEIGHT_OF_SCREEN);
            this.sprites.drawAllOn(d);
            this.gui.show(d);
            this.sprites.notifyAllTimePassed();

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * Gets keyboard.
     *
     * @return the keyboard
     */
    public KeyboardSensor getKeyboard() {
        return this.keyboard;
    }

    /**
     * Sets keyboard.
     *
     * @param newKeyboard the new keyboard
     */
    public void setKeyboard(KeyboardSensor newKeyboard) {
        this.keyboard = newKeyboard;
    }
}

