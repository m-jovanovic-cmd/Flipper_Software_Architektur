package util;

import components.targets.FlipperTarget;

import java.util.Random;

public class RandomEventGenerator {
    public boolean generateEvent(FlipperTarget event) {
        int chance = event.getChance();
        return doesEventOccur(chance);
    }

    public boolean generateEvent(FlipperTarget event, int multiplier) {
        int chance = event.getChance() * multiplier;
        if(chance > 100) chance = 100;
        return doesEventOccur(chance);
    }

    public boolean doesEventOccur(int chance) {
        Random random = new Random();
        int randomValue = random.nextInt(101);
        return randomValue <= chance;
    }

    public int randomNumberBetween(int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            throw new IllegalArgumentException("Upper bound must be greater than lower bound.");
        }

        Random random = new Random();
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
}