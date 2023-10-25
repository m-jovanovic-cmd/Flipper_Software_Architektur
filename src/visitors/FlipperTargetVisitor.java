package visitors;

import components.targets.*;

public class FlipperTargetVisitor {
    private int points;

    public void visit(Bumper bumper) {
        System.out.println("It is a Bumper!");
        points += bumper.getPointValue();
    }

    public void visit(Hole hole) {
        System.out.println("It is a Hole!");
        points += hole.getPointValue();
    }

    public void visit(Ramp ramp) {
        ramp.playEvent();
        points += ramp.getPointValue();
    }

    public void visit(Target target) {
        target.playEvent();
        points += target.getPointValue();
    }

    public int getCurrentPoints() {
        return points;
    }

}