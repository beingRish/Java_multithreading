package being.rish.Lecture17;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(numberOfServices);
        for (int i = 0; i < numberOfServices; i++) {
            new Thread(new DependentService(latch)).start();
        }
        executorService.submit(new DependentService((latch)));
        executorService.submit(new DependentService((latch)));
        executorService.submit(new DependentService((latch)));
        latch.await(5, TimeUnit.SECONDS);
        System.out.println("Main");
        executorService.shutdownNow();
    }
}

class DependentService implements Runnable {

    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(6000);
            System.out.println(Thread.currentThread().getName() + " service started.");
        } catch (Exception e) {

        } finally {
            latch.countDown();
        }
    }
}