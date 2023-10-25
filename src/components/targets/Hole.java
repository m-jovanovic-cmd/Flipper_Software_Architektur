package components.targets;

import visitors.FlipperTargetVisitor;

public class Hole extends FlipperTarget {
    private int hitChance = TargetHitChances.HOLE.getChance();
    private int pointValue = 300;
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