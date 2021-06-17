package game;
import geometry.primitives.Point;
import geometry.primitives.Rectangle;
import physics.Velocity;
import sprites.Circle;
import sprites.Sprite;
import sprites.colidables.Backround;
import sprites.colidables.Block;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Level three.
 */
public class LevelThree implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vList = new LinkedList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            vList.add(Velocity.fromAngleAndSpeed(i * 90 - 45, 10));
        }
        return vList;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Green";
    }

    @Override
    public Sprite getBackground() {
        List<Sprite> sList = new ArrayList<>();
        Block backBlock = new Block(new Rectangle(new Point(0, 0), 800, 600),
                new Color(0, 80, 0));
        sList.add(backBlock);
        Block baseTower = new Block(new Rectangle(new Point(50, 400), 100, 200), Color.black);
        sList.add(baseTower);
        for (int j = 420; j <= 600; j = j + 60) {
            for (int i = 1; i <= 3; i++) {
                Block window = new Block(new Rectangle(new Point(32 + (i * 30), j), 15, 40),
                        Color.white);
                sList.add(window);
            }
        }
        Block midTower = new Block(new Rectangle(new Point(75, 300), 50, 100),
                Color.darkGray);
        sList.add(midTower);
        Block topTower = new Block(new Rectangle(new Point(90, 150), 20, 150),
                Color.gray);
        sList.add(topTower);
        Circle lightBig = new Circle(new Point(100, 150), 10, Color.orange, Color.orange);
        sList.add(lightBig);
        Circle lightMid = new Circle(new Point(100, 150), 7, Color.red, Color.red);
        sList.add(lightMid);
        Circle lightSmall = new Circle(new Point(100, 150), 3, Color.white, Color.white);
        sList.add(lightSmall);
        return new Backround(sList);
    }

    @Override
    public List<Block> blocks() {
        List<Block> bList = new ArrayList<>();
        for (int i = 730; i > 230; i -= 50) {
            Block block = new Block(new Rectangle(new Point(i, 125), 50, 25), Color.gray);
            bList.add(block);
        }
        for (int i = 730; i > 280; i -= 50) {
            Block block = new Block(new Rectangle(new Point(i, 150), 50, 25), Color.red);
            bList.add(block);
        }
        for (int i = 730; i > 330; i -= 50) {
            Block block = new Block(new Rectangle(new Point(i, 175), 50, 25), Color.yellow);
            bList.add(block);
        }
        for (int i = 730; i > 380; i -= 50) {
            Block block = new Block(new Rectangle(new Point(i, 200), 50, 25), Color.blue);
            bList.add(block);
        }
        for (int i = 730; i > 430; i -= 50) {
            Block block = new Block(new Rectangle(new Point(i, 225), 50, 25), Color.white);
            bList.add(block);
        }
        return bList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
