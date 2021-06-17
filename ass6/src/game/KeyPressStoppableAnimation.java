package game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private boolean wasPressed;
    private boolean isAlreadyPressed;
    private Animation animation;
    private String key;

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.animation = animation;
        this.key = key;
        this.wasPressed = false;
        this.isAlreadyPressed = true;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed(this.key)) {
            if (!this.isAlreadyPressed) {
                this.wasPressed = true;
            }
        }
        if (!this.wasPressed) {
            this.animation.doOneFrame(d);
        }
        this.isAlreadyPressed = false;
    }

    @Override
    public boolean shouldStop() {
        return this.wasPressed;
    }
}