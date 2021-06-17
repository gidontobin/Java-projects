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
 * The type Level two.
 */
public class LevelTwo implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vList = new LinkedList<>();
        for (int i = 1; i <= this.numberOfBalls(); i++) {
            vList.add(Velocity.fromAngleAndSpeed(i * 10 - 45, 10));
        }
        return vList;
    }

    @Override
    public int paddleSpeed() {
        return 2;
    }

    @Override
    public int paddleWidth() {
        return 500;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        List<Sprite> sList = new ArrayList<>();
        Block backBlock = new Block(new Rectangle(new Point(0, 0), 800, 600), Color.white);
        sList.add(backBlock);
        Color sun = new Color(240, 240, 180);
        for (int i = 0; i < 800; i += 5) {
            LineDraw b = new LineDraw(new Line(new Point(200, 125), new Point(i, 300)), sun);
            sList.add(b);
        }
        Circle sunBig = new Circle(new Point(200, 125), 60, sun, sun);
        sList.add(sunBig);
        Circle sunMid = new Circle(new Point(200, 125), 50, Color.orange, Color.orange);
        sList.add(sunMid);
        Circle sunSmall = new Circle(new Point(200, 125), 40, Color.yellow, Color.yellow);
        sList.add(sunSmall);
        return new Backround(sList);
    }

    @Override
    public List<Block> blocks() {
        List<Block> bList = new ArrayList<>();
        for (int i = 20; i < 730; i += 50) {
            Block block;
            if (i <= 70) {
                block = new Block(new Rectangle(new Point(i, 300), 50, 20),
                        new Color(200, 0, 0));
            } else if (i <= 170) {
                block = new Block(new Rectangle(new Point(i, 300), 50, 20),
                        new Color(200, 100, 0));
            } else if (i <= 270) {
                block = new Block(new Rectangle(new Point(i, 300), 50, 20),
                        new Color(200, 200, 0));
            } else if (i <= 420) {
                block = new Block(new Rectangle(new Point(i, 300), 50, 20),
                        new Color(0, 200, 0));
            } else if (i <= 520) {
                block = new Block(new Rectangle(new Point(i, 300), 50, 20),
                        new Color(0, 0, 200));
            } else if (i <= 620) {
                block = new Block(new Rectangle(new Point(i, 300), 50, 20),
                        new Color(250, 0, 250));
            } else {
                block = new Block(new Rectangle(new Point(i, 300), 60, 20),
                        new Color(0, 200, 200));
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
