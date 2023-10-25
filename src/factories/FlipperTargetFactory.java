package factories;

import components.targets.FlipperTarget;
import util.ClassFinder;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlipperTargetFactory {
    private static List<Class<? extends FlipperTarget>> targetClasses = new ArrayList<>();

    static {
        String packageName = "components.targets";

        try {
            ClassLoader classLoader = FlipperTargetFactory.class.getClassLoader();
            List<Class<?>> allClasses = ClassFinder.find(packageName, classLoader);

            for (Class<?> clazz : allClasses) {
                if (FlipperTarget.class.isAssignableFrom(clazz) && !Modifier.isAbstract(clazz.getModifiers())) {
                    targetClasses.add((Class<? extends FlipperTarget>) clazz);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static FlipperTarget createRandomTarget() {
        int randomValue = new Random().nextInt(100);
        int lowerBound = 0;

        for (Class<? extends FlipperTarget> targetClass : targetClasses) {
            try {
                FlipperTarget instance = targetClass.getDeclaredConstructor().newInstance();
                int upperBound = lowerBound + instance.getChance();
                if (randomValue >= lowerBound && randomValue < upperBound) {
                    return instance;
                }
                lowerBound = upperBound;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static ArrayList<FlipperTarget> createRandomTargetList(int amount) {
        ArrayList<FlipperTarget> targetResults = new ArrayList<>();
        int randomValue;
        int lowerBound;
        for(int i = 0; i < amount; i++) {
            lowerBound = 0;
            randomValue = new Random().nextInt(100);
            for (Class<? extends FlipperTarget> targetClass : targetClasses) {
                try {
                    FlipperTarget instance = targetClass.getDeclaredConstructor().newInstance();
                    int upperBound = lowerBound + instance.getChance();
                    if (randomValue >= lowerBound && randomValue < upperBound) {
                        targetResults.add(instance);
                    }
                    lowerBound = upperBound;
                } catch (Exception e) {
                }
            }
        }
        return targetResults;
    }
}