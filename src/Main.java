import components.Flipper;
import components.targets.*;
import factories.FlipperTargetFactory;
import visitors.FlipperTargetVisitor;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        FlipperTargetVisitor visitor = new FlipperTargetVisitor();
        FlipperTargetFactory factory = new FlipperTargetFactory();
        /*List<FlipperTarget> targetList = factory.createRandomTargetList(4);
        for(FlipperTarget target: targetList) {
            System.out.println(target instanceof Bumper);
            System.out.println(target instanceof Hole);
            System.out.println(target instanceof Ramp);
            System.out.println(target instanceof Target);
            target.accept(visitor);
        }

        System.out.printf("%d\n",visitor.getCurrentPoints());*/

        Flipper flipper = Flipper.getInstance();
        /*flipper.start();
        flipper.leftControl();
        flipper.rightControl();
        flipper.rightControl();
        flipper.insertCoin();
        flipper.start();
        flipper.insertCoin();
        flipper.insertCoin();*/

        while(true) {
            String input = scanner.nextLine().toLowerCase();
            switch(input) {
                case("insert"):
                    flipper.insertCoin();
                    break;
                case("start"):
                    flipper.start();
                    break;
                case("l"):
                    flipper.leftControl();
                    break;
                case("r"):
                    flipper.rightControl();
                    break;
                case("b"):
                    flipper.bothControl();
                    break;
                case("stecker ziehen"):
                    System.out.printf("Bzz..");
                    return;
                default: System.out.printf("Keine gültige Eingabe.\n");
            }
        }
    }
}