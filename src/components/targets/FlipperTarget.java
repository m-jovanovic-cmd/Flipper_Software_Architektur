package components.targets;

import visitors.FlipperTargetVisitor;

public abstract class FlipperTarget {
    private int hitChance;
    private int pointValue;
    public abstract void accept(FlipperTargetVisitor visitor);
    public abstract int getChance();
    public abstract int getPointValue();
}