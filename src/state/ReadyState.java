package state;

import components.Flipper;

public class ReadyState extends FlipperState {

    public ReadyState(Flipper flipper) {
        super(flipper);
    }

    private String message =
            "\nWillkommen im Spiel." +
            "\nSteuerung:" +
            "\n[L] + Enter = Linker Flipper" +
            "\n[R] + Enter = Rechter Flipper" +
            "\n[B] + Enter = Beide Flipper" +
            "\n\nZum Starten des Spiels geben Sie 'Start' ein und drücken Sie Enter.\n\n";

    @Override
    public void insertCoin() {
        Flipper flipper = getFlipper();
        System.out.printf("Münze wurde eingeworfen! ");
        flipper.addOneCredit();
        System.out.printf( "Sie haben %d %s.\n", flipper.getCredit(), flipper.getCredit() > 1 ? "Credits" : "Credit");
    }

    @Override
    public void start() {
        Flipper flipper = getFlipper();
        flipper.useOneCredit();
        System.out.printf("Spiel startet!\n");
        flipper.setState(new PlayingState(flipper));
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