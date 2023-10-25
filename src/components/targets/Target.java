package components.targets;

import components.Flipper;
import visitors.FlipperTargetVisitor;

public class Target extends FlipperTarget {
    private int hitChance = TargetHitChances.TARGET.getChance();
    private static int pointValue = 100;
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
        System.out.printf("Der Pinball bounced gegen ein Target! Plus %d Punkte!\n", pointValue);
    }

    public static void setPointValue(double multiplier) {
        pointValue = (int)(pointValue * multiplier);
    }
}