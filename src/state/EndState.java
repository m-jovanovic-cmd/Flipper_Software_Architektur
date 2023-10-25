package state;

import components.Flipper;

public class EndState extends FlipperState {
    public EndState(Flipper flipper) {
        super(flipper);
    }

    private String message = "Text";

    @Override
    public void insertCoin() {
        Flipper flipper = getFlipper();
        System.out.printf("Münze wurde eingeworfen! ");
        flipper.addOneCredit();
        System.out.printf( "Sie haben %d Credits.\n", flipper.getCredit());
    }

    @Override
    public void start() {

    }

    @Override
    public void leftControl() {

    }

    @Override
    public void rightControl() {

    }

    @Override
    public void bothControl() {

    }

    @Override
    public String getMessage() {
        return message;
    }
}