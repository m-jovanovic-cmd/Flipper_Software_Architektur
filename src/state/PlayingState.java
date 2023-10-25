package state;

import components.Flipper;
import components.targets.FlipperTarget;
import factories.FlipperTargetFactory;
import util.RandomEventGenerator;
import visitors.FlipperTargetVisitor;

import java.util.List;

public class PlayingState extends FlipperState {

    public PlayingState(Flipper flipper) {
        super(flipper);
    }

    private FlipperTargetFactory targetFactory = new FlipperTargetFactory();
    private FlipperTargetVisitor targetVisitor = new FlipperTargetVisitor();
    private RandomEventGenerator randomGenerator = new RandomEventGenerator();

    private String message = "Der Ball wird hochgeschossen!\n";

    @Override
    public void insertCoin() {
        Flipper flipper = getFlipper();
        System.out.printf("Münze wurde eingeworfen! ");
        flipper.addOneCredit();
        System.out.printf( "Sie haben %d Credits.\n", flipper.getCredit());
    }

    @Override
    public void start() {
        System.out.printf("Sie befinden sich bereits im Spiel!\n");
    }

    @Override
    public void leftControl() {
        List<FlipperTarget> targetList = targetFactory.createRandomTargetList(randomGenerator.randomNumberBetween(0, 5));
        if (targetList.size() == 0) {
            System.out.printf("Pinball hat nichts getroffen.");
        } else {
            for ( FlipperTarget target: targetList ) {
                target.accept(targetVisitor);
            }
        }
        System.out.printf("%d\n",targetVisitor.getCurrentPoints());
    }

    @Override
    public void rightControl() {
        List<FlipperTarget> targetList = targetFactory.createRandomTargetList(randomGenerator.randomNumberBetween(0, 5));
        if (targetList.size() == 0) {
            System.out.printf("Pinball hat nichts getroffen.\n");
        } else {
            for ( FlipperTarget target: targetList ) {
                target.accept(targetVisitor);
                System.out.printf("%d\n",targetVisitor.getCurrentPoints());
            }
        }
        System.out.printf("%d\n",targetVisitor.getCurrentPoints());
    }

    @Override
    public void bothControl() {
        List<FlipperTarget> targetList = targetFactory.createRandomTargetList(randomGenerator.randomNumberBetween(0, 5));
        if (targetList.size() == 0) {
            System.out.printf("Pinball hat nichts getroffen.");
        } else {
            for ( FlipperTarget target: targetList ) {
                target.accept(targetVisitor);
            }
        }
        System.out.printf("%d\n",targetVisitor.getCurrentPoints());
    }

    @Override
    public String getMessage() {
        return message;
    }
}