package being.rish.Lecture16;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main5 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(
                () -> System.out.println("Task executed after 5 second delay !"),
                5,
                TimeUnit.SECONDS
        );

        scheduler.scheduleAtFixedRate(
                () -> System.out.println("Task executeed after every 5 seconds !"),
                5,
                5,
                TimeUnit.SECONDS
        );

        scheduler.scheduleWithFixedDelay(
                () -> System.out.println("Task executeed after every 5 seconds !"),
                5,
                5,
                TimeUnit.SECONDS
        );

        scheduler.schedule(
            () -> {
                System.out.println("Initiating shutdown...");
                scheduler.shutdown();
            },
            20,
            TimeUnit.SECONDS
        );
    }
}
