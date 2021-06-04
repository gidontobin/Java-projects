// ID: 320518020

package responders.removers;
import game.Game;
import responders.Counter;
import responders.listeners.HitListener;
import sprites.Ball;
import sprites.colidables.Block;

/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener {
    private Game game;
    private Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     *
     * @param game          the game
     * @param removedBlocks the removed blocks
     */
    public BallRemover(Game game, Counter removedBlocks) {
        this.game = game;
        this.remainingBalls = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBalls.decrease(1);
        hitter.removeFromGame(this.game);
    }
}
