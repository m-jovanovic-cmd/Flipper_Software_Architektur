package components.targets;

import visitors.FlipperTargetVisitor;

public class Target extends FlipperTarget {
    private int hitChance = TargetHitChances.TARGET.getChance();
    private int pointValue = 100;
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