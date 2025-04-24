package being.rish.Lecture16;

import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(() -> System.out.println("Hello"));
        future.get();
        executorService.shutdown();
        executorService.submit(() -> System.out.println("Hello"), "success");
    }
}
