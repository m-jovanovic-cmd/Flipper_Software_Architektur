package components.targets;

import components.Flipper;
import util.SleepTimer;
import visitors.FlipperTargetVisitor;

public class Ramp extends FlipperTarget {
    private int hitChance = TargetHitChances.RAMP.getChance();
    private int pointValue = 140;

    @Override
    public void accept(FlipperTargetVisitor flipperTargetVisitor) {
        flipperTargetVisitor.visit(this);
    }

    @Override
    public int getChance() {
        return hitChance;
    }

    @Override
    public int getPointValue() {
        return pointValue;
    }

    @Override
    public void playEvent() {
        String eventMessage;
        Flipper flipper = Flipper.getInstance();
        System.out.printf("Pinball fliegt über die Rampe!\n");
        flipper.setRampIsExtended(!flipper.isRampIsExtended());
        if (flipper.isRampIsExtended()) {
            eventMessage = "Die Rampe geht hoch! Targets geben ab jetzt doppelte Punkte!\n";
            Target.setPointValue(2);
        } else {
            eventMessage = "Die Rampe fährt runter! Targets geben wieder nur die normale Punkteanzahl!\n";
            Target.setPointValue(0.5);
        }
        SleepTimer.writeAndSleep(1, eventMessage);
    }
}