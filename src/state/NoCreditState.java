package state;

import components.Flipper;

public class NoCreditState extends FlipperState {
    public NoCreditState(Flipper flipper) {
        super(flipper);
    }

    private String message = "Keine Credits mehr vorhanden.\n";

    @Override
    public void insertCoin() {
        Flipper flipper = getFlipper();
        System.out.printf("Münze wurde eingeworfen! ");
        flipper.addOneCredit();
        System.out.printf( "Sie haben %d %s.\n", flipper.getCredit(), flipper.getCredit() > 1 ? "Credits" : "Credit");
        flipper.setState(new ReadyState(flipper));
    }

    @Override
    public void start() {
        System.out.printf("Das Spiel kann nicht gestartet werden ohne Credits!\nWerfen Sie zuerst eine Münze ein.\n");
    }

    @Override
    public void leftControl() {
        System.out.printf("Der linke Flipper bewegt sich..\n");
    }

    @Override
    public void rightControl() {
        System.out.printf("Der rechte Flipper bewegt sich..\n");
    }

    @Override
    public void bothControl() {
        System.out.printf("Beide Flipper bewegen sich..\n");
    }

    @Override
    public String getMessage() {
        return message;
    }
}