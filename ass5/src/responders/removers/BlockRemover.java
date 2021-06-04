// ID: 320518020

package responders.removers;
import game.Game;
import responders.Counter;
import responders.listeners.HitListener;
import sprites.Ball;
import sprites.colidables.Block;

/**
 * The type Block remover.
 *
 * In charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private Game game;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param game          the game
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(Game game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
        this.remainingBlocks.increase(1);
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBlocks.decrease(1);
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
    }
}