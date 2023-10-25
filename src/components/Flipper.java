package components;

import state.FlipperState;
import state.NoCreditState;

import java.util.concurrent.TimeUnit;

public class Flipper {
    private static Flipper instance;
    private FlipperState state;

    private int credit = 0;
    private Flipper() {
        this.state = new NoCreditState(this);
        System.out.printf("Spiel startet");
        for(int i = 0; i < 3; i++) {
            try {
                System.out.printf(".");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("\nWerfen Sie eine Münze ein mit 'insert'.\n");
    };

    public static Flipper getInstance() {
        if (instance == null) {
            instance = new Flipper();
        }
        return instance;
    }

    public void insertCoin() { state.insertCoin(); }
    public void start() { state.start(); }
    public void leftControl() { state.leftControl(); }
    public void rightControl() { state.rightControl(); }
    public void bothControl() { state.bothControl(); }

    public void setState(FlipperState state) {
        this.state = state;
        if(state.getMessage() != null) {
            System.out.printf(state.getMessage());
        }
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void addOneCredit() {
        this.credit += 1;
    }

    public void useOneCredit() {
        this.credit -= 1;
    }
}