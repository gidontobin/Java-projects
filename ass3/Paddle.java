// ID: 320518020

import biuoop.DrawSurface;

/**
 * The type Paddle.
 *
 * @author Gidon tobin
 * @version 1.0 27 April 2021
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Block block;
    private double speed;
    private double leftBorder;
    private double rightBorder;

    /**
     * Instantiates a new Paddle.
     *
     * @param block the block
     * @param speed the speed
     */
    public Paddle(Block block, double speed, double leftBorder, double rightBorder) {
        this.block = block;
        this.speed = speed;
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
    }

    /**
     * Move left.
     */
    public void moveLeft() {
        if (this.block.getCollisionRectangle().getUpperLeft().getX() > this.leftBorder) {
            Point newPoint = new Point(this.block.getCollisionRectangle().getUpperLeft().getX() - this.speed,
                    this.block.getCollisionRectangle().getUpperLeft().getY());
            this.block.setCollisionRectangle(new Rectangle(newPoint, this.block.getCollisionRectangle().getWidth(),
                    this.block.getCollisionRectangle().getHeight()));
        }
    }

    /**
     * Move right.
     */
    public void moveRight() {
        if (this.block.getCollisionRectangle().getUpperLeft().getX() + this.block.getCollisionRectangle().getWidth()
                < this.rightBorder) {
            Point newPoint = new Point(this.block.getCollisionRectangle().getUpperLeft().getX() + this.speed,
                    this.block.getCollisionRectangle().getUpperLeft().getY());
            this.block.setCollisionRectangle(new Rectangle(newPoint, this.block.getCollisionRectangle().getWidth(),
                    this.block.getCollisionRectangle().getHeight()));
        }
    }

    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(this.keyboard.LEFT_KEY)) {
            this.moveLeft();
        }
        if (this.keyboard.isPressed(this.keyboard.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        this.block.drawOn(d);
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.block.getCollisionRectangle();
    }

    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = null;
        //incase hits top of paddle
        if (this.block.getCollisionRectangle().getTopLine().isPointOnLine(collisionPoint)) {
            if (this.getSection(1).isPointOnLine(collisionPoint)) {
                newVelocity = Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
            } else if (getSection(2).isPointOnLine(collisionPoint)) {
                newVelocity = Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
            } else if (getSection(3).isPointOnLine(collisionPoint)) {
                newVelocity = this.block.hit(collisionPoint, currentVelocity);
            } else if (getSection(4).isPointOnLine(collisionPoint)) {
                newVelocity = Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
            } else if (getSection(5).isPointOnLine(collisionPoint)) {
                newVelocity = Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
            }
        } else {
            newVelocity = this.block.hit(collisionPoint, currentVelocity);
        }
        return newVelocity;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g the game
     */
    public void addToGame(Game g) {
        g.addCollidable(this);
        g.addSprite(this);
        this.keyboard = g.getKeyboard();
    }

    /**
     * Gets section of the top of the paddle.
     *
     * @param num the number of the section
     * @return the section
     */
    public Line getSection(int num) {
        double withSection = (this.block.getCollisionRectangle().getWidth() / 5);
        double startX = this.block.getCollisionRectangle().getUpperLeft().getX();
        double topY = this.block.getCollisionRectangle().getUpperLeft().getY();
        Line sectionOne = new Line(this.block.getCollisionRectangle().getUpperLeft(),
                new Point(startX + withSection, topY));
        Line sectionTwo = new Line(startX + withSection, topY, startX + withSection * 2, topY);
        Line sectionThree = new Line(startX + withSection * 2, topY, startX + withSection * 3, topY);
        Line sectionFour = new Line(startX + withSection * 3, topY, startX + withSection * 4, topY);
        Line sectionFive = new Line(startX + withSection * 4, topY, startX + withSection * 5, topY);
        return switch (num) {
            case 1 -> sectionOne;
            case 2 -> sectionTwo;
            case 3 -> sectionThree;
            case 4 -> sectionFour;
            case 5 -> sectionFive;
            default -> null;
        };
    }

    /**
     * Move point from paddle point.
     *
     * @param point the point
     * @return the point
     */
    public Point movePointFromPaddle(Point point) {
        //incase ball is in paddle
        if (this.block.getCollisionRectangle().isInsideRect(point)) {
            //the point will be above the paddle
            return new Point(point.getX(), this.block.getCollisionRectangle().getTopLine().start().getY() - 1);
        }
        return point;
    }
}