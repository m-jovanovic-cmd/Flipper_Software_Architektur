package util;

import java.util.concurrent.TimeUnit;

public class SleepTimer {

    public SleepTimer() {
    }

    public static void writeAndSleep(int time, String message) {
        try {
            System.out.printf("%s", message);
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
