// ID: 320518020

package responders.removers;
import game.GameLevel;
import responders.Counter;
import responders.listeners.HitListener;
import sprites.Ball;
import sprites.colidables.Block;

/**
 * The type Block remover.
 * <p>
 * In charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param gameLevel     the game
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
        this.remainingBlocks.increase(1);
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
            this.remainingBlocks.decrease(1);
            beingHit.removeFromGame(this.gameLevel);
            beingHit.removeHitListener(this);
    }
}