package state;

import components.Flipper;

public class PlayingState extends FlipperState {

    public PlayingState(Flipper flipper) {
        super(flipper);
    }

    private String message = "Der Ball wird hochgeschossen!\n";

    @Override
    public void insertCoin() {
        Flipper flipper = getFlipper();
        System.out.printf("Münze wurde eingeworfen! ");
        flipper.addOneCredit();
        System.out.printf( "Sie haben %d Credits.\n", flipper.getCredit());
    }

    @Override
    public void start() {
        System.out.printf("Sie befinden sich bereits im Spiel!\n");
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