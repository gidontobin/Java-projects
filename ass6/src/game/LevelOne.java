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
 * The type Level one.
 */
public class LevelOne implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vList = new LinkedList<>();
        for (int i = 1; i <= this.numberOfBalls(); i++) {
            vList.add(Velocity.fromAngleAndSpeed(180, 10));
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
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        List<Sprite> sList = new ArrayList<>();
        Block backBlock = new Block(new Rectangle(new Point(0, 0), 800, 600), Color.black);
        sList.add(backBlock);
        Circle big = new Circle(new Point(400, 125), 120, Color.black, Color.blue);
        sList.add(big);
        Circle mid = new Circle(new Point(400, 125), 90, Color.black, Color.blue);
        sList.add(mid);
        Circle small = new Circle(new Point(400, 125), 60, Color.black, Color.blue);
        sList.add(small);
        LineDraw r = new LineDraw(new Line(new Point(250, 125), new Point(370, 125)), Color.blue);
        sList.add(r);
        LineDraw l = new LineDraw(new Line(new Point(430, 125), new Point(550, 125)), Color.blue);
        sList.add(l);
        LineDraw t = new LineDraw(new Line(new Point(400, 0), new Point(400, 100)), Color.blue);
        sList.add(t);
        LineDraw b = new LineDraw(new Line(new Point(400, 150), new Point(400, 270)), Color.blue);
        sList.add(b);
        return new Backround(sList);
    }

    @Override
    public List<Block> blocks() {
        List<Block> bList = new ArrayList<>();
        Block block = new Block(new Rectangle(new Point(375, 100), 50, 50), Color.RED);
        bList.add(block);
        return bList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
