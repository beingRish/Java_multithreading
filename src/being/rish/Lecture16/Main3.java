package being.rish.Lecture16;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> submit = executorService.submit(() -> 1 + 2);
        Integer i = submit.get();
        System.out.println("Sum is " + i);
        executorService.shutdown();
        Thread.sleep(1);
        System.out.println(executorService.isTerminated());
    }
}
