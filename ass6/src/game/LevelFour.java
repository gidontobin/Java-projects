package game;
import geometry.primitives.Line;
import geometry.primitives.Point;
import geometry.primitives.Rectangle;
import physics.Velocity;
import sprites.Circle;
import sprites.LineDraw;
import sprites.Sprite;
import sprites.colidables.Backround;
import sprites.colidables.Block;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Level four.
 */
public class LevelFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vList = new LinkedList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            vList.add(Velocity.fromAngleAndSpeed(i * 15 - 15, 10));
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        List<Sprite> sList = new ArrayList<>();
        Block backBlock = new Block(new Rectangle(new Point(0, 0), 800, 600),
                new Color(100, 100, 250));
        sList.add(backBlock);
        for (int i = 100; i < 200; i += 10) {
            LineDraw b = new LineDraw(new Line(new Point(i, 500), new Point(i - 10, 600)), Color.white);
            sList.add(b);
        }
        for (int i = 500; i < 700; i += 20) {
            LineDraw b = new LineDraw(new Line(new Point(i, 500), new Point(i + 10, 600)), Color.white);
            sList.add(b);
        }
        for (int i = 110; i < 200; i += 60) {
            Color cloudColor = new Color(250, 250, 250);
            Circle cloud = new Circle(new Point(i, 500), 20, cloudColor, cloudColor);
            sList.add(cloud);
        }
        for (int i = 100; i < 200; i += 20) {
            Color cloudColor = new Color(250, 250, 250);
            Circle cloud = new Circle(new Point(i, 500), 15, cloudColor, cloudColor);
            sList.add(cloud);
        }
        for (int i = 100; i < 200; i += 30) {
            Color cloudColor = new Color(250, 250, 250);
            Circle cloud = new Circle(new Point(i, 485), 10, cloudColor, cloudColor);
            sList.add(cloud);
        }
        for (int i = 520; i > 350; i -= 20) {
            Color cloudColor = new Color(240, 240, 240);
            Circle cloud = new Circle(new Point(i + 150, 500), 20, cloudColor, cloudColor);
            sList.add(cloud);
        }
        for (int i = 520; i > 350; i -= 30) {
            Color cloudColor = new Color(240, 240, 240);
            Circle cloud = new Circle(new Point(i + 150, 480), 10, cloudColor, cloudColor);
            sList.add(cloud);
        }
        return new Backround(sList);
    }

    @Override
    public List<Block> blocks() {
        List<Block> bList = new ArrayList<>();
        int blockSize = 51;
        for (double i = 20; i < 750; i += blockSize) {
            Block block;
            if (i + blockSize > 780) {
                block = new Block(new Rectangle(new Point(i, 125),
                        blockSize - ((i + blockSize) - 780), 25), Color.GRAY);
            } else {
                block = new Block(new Rectangle(new Point(i, 125), blockSize, 25), Color.GRAY);
            }
            bList.add(block);
        }
        for (double i = 20; i < 750; i += blockSize) {
            Block block;
            if (i + blockSize > 780) {
                block = new Block(new Rectangle(new Point(i, 150),
                        blockSize - ((i + blockSize) - 780), 25), Color.red);
            } else {
                block = new Block(new Rectangle(new Point(i, 150), blockSize, 25), Color.red);
            }
            bList.add(block);
        }
        for (double i = 20; i < 750; i += blockSize) {
            Block block;
            if (i + blockSize > 780) {
                block = new Block(new Rectangle(new Point(i, 175),
                        blockSize - ((i + blockSize) - 780), 25), Color.yellow);
            } else {
                block = new Block(new Rectangle(new Point(i, 175), blockSize, 25), Color.yellow);
            }
            bList.add(block);
        }
        for (double i = 20; i < 750; i += blockSize) {
            Block block;
            if (i + blockSize > 780) {
                block = new Block(new Rectangle(new Point(i, 200),
                        blockSize - ((i + blockSize) - 780), 25), Color.GREEN);
            } else {
                block = new Block(new Rectangle(new Point(i, 200), blockSize, 25), Color.GREEN);
            }
            bList.add(block);
        }
        for (double i = 20; i < 750; i += blockSize) {
            Block block;
            if (i + blockSize > 780) {
                block = new Block(new Rectangle(new Point(i, 225),
                        blockSize - ((i + blockSize) - 780), 25), Color.white);
            } else {
                block = new Block(new Rectangle(new Point(i, 225), blockSize, 25), Color.WHITE);
            }
            bList.add(block);
        }
        for (double i = 20; i < 750; i += blockSize) {
            Block block;
            if (i + blockSize > 780) {
                block = new Block(new Rectangle(new Point(i, 250),
                        blockSize - ((i + blockSize) - 780), 25), Color.PINK);
            } else {
                block = new Block(new Rectangle(new Point(i, 250), blockSize, 25), Color.PINK);
            }
            bList.add(block);
        }
        for (double i = 20; i < 750; i += blockSize) {
            Block block;
            if (i + blockSize > 780) {
                block = new Block(new Rectangle(new Point(i, 275),
                        blockSize - ((i + blockSize) - 780), 25), Color.cyan);
            } else {
                block = new Block(new Rectangle(new Point(i, 275), blockSize, 25), Color.cyan);
            }
            bList.add(block);
        }
        return bList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
