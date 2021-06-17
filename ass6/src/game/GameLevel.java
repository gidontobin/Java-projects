// ID: 320518020

package game;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import geometry.primitives.Point;
import geometry.primitives.Rectangle;
import physics.Velocity;
import responders.Counter;
import responders.listeners.ScoreTrackingListener;
import responders.removers.BallRemover;
import responders.removers.BlockRemover;
import sprites.NameOfLevel;
import sprites.ScoreIndicator;
import sprites.Sprite;
import sprites.SpriteCollection;
import sprites.colidables.Block;
import sprites.colidables.Collidable;
import sprites.colidables.GameEnvironment;
import sprites.colidables.Paddle;
import sprites.Ball;
import java.awt.Color;

/**
 * The type game.Game.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public class GameLevel implements Animation {
    private static final int WIDTH_OF_SCREEN = 800;
    private static final int HEIGHT_OF_SCREEN = 600;
    private static final int BORDER_SIZE = 20;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private biuoop.KeyboardSensor keyboard;
    private Counter blockCount;
    private Counter ballCount;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation level;

    /**
     * Instantiates a new game.Game.
     *
     * @param level the level
     * @param score the score
     * @param gui   the gui
     */
    public GameLevel(LevelInformation level, Counter score, GUI gui) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blockCount = new Counter();
        this.ballCount = new Counter();
        this.score = score;
        this.level = level;
        this.gui = gui;

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
     * Initialize a new game: create the Blocks and sprites.Ball (and sprites.colidables.Paddle)
     * and add them to the game.
     */
    public void initialize() {
        this.keyboard = this.gui.getKeyboardSensor();
        this.sprites.addSprite(this.level.getBackground());
        Paddle paddle = new Paddle(new Block(new Rectangle(new Point(400 - ((double) level.paddleWidth() / 2),
                560), level.paddleWidth(), 20), Color.YELLOW), level.paddleSpeed(), BORDER_SIZE,
                WIDTH_OF_SCREEN - BORDER_SIZE);
        paddle.addToGame(this);
        //make and add border blocks
        Block top = new Block(new Rectangle(new Point(0, 20), WIDTH_OF_SCREEN, BORDER_SIZE), Color.GRAY);
        Block left = new Block(new Rectangle(new Point(0, 0), BORDER_SIZE, HEIGHT_OF_SCREEN), Color.GRAY);
        Block right = new Block(new Rectangle(new Point(WIDTH_OF_SCREEN - BORDER_SIZE, 0), BORDER_SIZE,
                HEIGHT_OF_SCREEN), Color.GRAY);
        Block deathRegion = new Block(new Rectangle(new Point(0, HEIGHT_OF_SCREEN), WIDTH_OF_SCREEN,
                BORDER_SIZE));
        top.addToGame(this);
        left.addToGame(this);
        right.addToGame(this);
        deathRegion.addToGame(this);
        deathRegion.addHitListener(new BallRemover(this, this.ballCount));
        ScoreIndicator showScore = new ScoreIndicator(this.score);
        this.sprites.addSprite(showScore);
        this.sprites.addSprite(new NameOfLevel(this.level.levelName()));
        this.makeGameBlocks();
        this.makeGameBalls();

    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner = new AnimationRunner(this.gui);
        this.running = true;
        this.runner.run(new CountdownAnimation(2, 3, this.sprites)); // countdown before turn starts.
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner = new AnimationRunner(this.gui);
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
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

    /**
     * Makes game blocks.
     */
    private void makeGameBlocks() {
        //make and add game blocks
        for (Block block : this.level.blocks()) {
            block.addToGame(this);
            block.addHitListener(new BlockRemover(this, this.blockCount));
            block.addHitListener(new ScoreTrackingListener(this.score));
        }
    }

    /**
     * Makes game balls.
     */
    private void makeGameBalls() {
        for (Velocity v : this.level.initialBallVelocities()) {
            Ball ball = new Ball(new Point(400, 500), 5, Color.white);
            ball.setVelocity(v);
            ball.addToGame(this);
            this.ballCount.increase(1);
        }
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.blockCount.getValue() == 0 || this.ballCount.getValue() == 0) {
            if (this.blockCount.getValue() == 0) {
                this.score.increase(100);
            }
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.getKeyboard(), "space",
                    new PauseScreen(this.keyboard)));
        }


    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Gets blocks left.
     *
     * @return the blocks left
     */
    public int getBlocksLeft() {
        return this.blockCount.getValue();
    }

    /**
     * Gets balls left.
     *
     * @return the balls left
     */
    public int getBallsLeft() {
        return this.ballCount.getValue();
    }
}

