package state;

import components.Flipper;

public abstract class FlipperState {
    private final Flipper flipper;

    public FlipperState(Flipper flipper) {
        this.flipper = flipper;
    }
    public Flipper getFlipper() {
        return flipper;
    }
    public abstract void insertCoin();
    public abstract void start();
    public abstract void leftControl();
    public abstract void rightControl();
    public abstract void bothControl();
    public abstract String getMessage();
}