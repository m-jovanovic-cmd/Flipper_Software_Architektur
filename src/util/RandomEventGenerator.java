package util;

import components.targets.FlipperTarget;

import java.util.Random;

public class RandomEventGenerator {
    public static boolean generateEvent(FlipperTarget event) {
        int chance = event.getChance();
        return doesEventOccur(chance);
    }

    public static boolean generateEvent(FlipperTarget event, int multiplier) {
        int chance = event.getChance() * multiplier;
        if(chance > 100) chance = 100;
        return doesEventOccur(chance);
    }

    private static boolean doesEventOccur(int chance) {
        Random random = new Random();
        int randomValue = random.nextInt(101);
        return randomValue <= chance;
    }
}