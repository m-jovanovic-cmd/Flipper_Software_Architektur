package components.targets;

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
}