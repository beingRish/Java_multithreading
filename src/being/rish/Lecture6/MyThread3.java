package being.rish.Lecture6;

//interrupt Method

public class MyThread3 extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Thread is running.....");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread3 t1 = new MyThread3();
        t1.start();
        t1.interrupt();
    }
}