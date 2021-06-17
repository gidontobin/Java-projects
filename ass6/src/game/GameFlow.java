package game;

import biuoop.GUI;
import responders.Counter;

import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {
    private Counter score;
    private GUI gui;

    /**
     * Instantiates a new Game flow.
     */
    public GameFlow() {
        this.score = new Counter();
        this.gui = new GUI("Arkanoid", 800, 600);
    }

    /**
     * Run levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        AnimationRunner runner = new AnimationRunner(this.gui);
        int currentLevel = 0;
        for (LevelInformation levelInfo : levels) {
            currentLevel++;
            GameLevel level = new GameLevel(levelInfo, this.score, this.gui);
            level.initialize();
            while (level.getBlocksLeft() != 0 && level.getBallsLeft() != 0) {
                level.run();
            }
            if (level.getBallsLeft() == 0) {
                Animation gameOver = new EndScreen(level.getKeyboard(), this.score, "Game Over. Your score is ");
                runner.run(new KeyPressStoppableAnimation(level.getKeyboard(), "space", gameOver));
                break;
            }
            if (currentLevel == levels.size()) {
                Animation win = new EndScreen(level.getKeyboard(), this.score, "You Win! Your score is ");
                runner.run(new KeyPressStoppableAnimation(level.getKeyboard(), "space", win));
            }
        }
        this.gui.close();
    }
}
