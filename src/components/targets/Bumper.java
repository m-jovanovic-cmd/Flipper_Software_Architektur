package components.targets;

import visitors.FlipperTargetVisitor;

public class Bumper extends FlipperTarget {
    private int hitChance = TargetHitChances.BUMPER.getChance();
    private int pointValue = 200;
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