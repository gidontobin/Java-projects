// ID: 320518020

package responders.removers;
import game.GameLevel;
import responders.Counter;
import responders.listeners.HitListener;
import sprites.Ball;
import sprites.colidables.Block;

/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     *
     * @param gameLevel     the game
     * @param removedBlocks the removed blocks
     */
    public BallRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBalls.decrease(1);
        hitter.removeFromGame(this.gameLevel);
    }
}
