package components.targets;

public enum TargetHitChances {
    BUMPER(15),
    HOLE(10),
    RAMP(15),
    TARGET(60);

    private int chance;
    private static final int MAX_TOTAL_CHANCE = 100;

    static {
        if (isInvalidChanceSum()) {
            System.err.printf("Total chance exceeds 100. ");
            throw new IllegalArgumentException("Total chance exceeds 100.");
        }
    }

    TargetHitChances(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }

    private static boolean isInvalidChanceSum() {
        int totalChance = 0;
        for (TargetHitChances chance : TargetHitChances.values()) {
            totalChance += chance.chance;
        }
        return totalChance > MAX_TOTAL_CHANCE;
    }
}