package being.rish.Lecture6;

/*
DAEMON THREADS
setDaemon Method:
Marks this thread as either a daemon thread or a user thread.
The Java Virtual Machine exits when the only threads running are all daemon threads.
*/

public class MyThread5 extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("Hello World!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread5 t1 = new MyThread5();
        t1.setDaemon(true);
//        MyThread5 t2 = new MyThread5();
//        t2.start();
        t1.start();
        System.out.println("Main done");
    }
}

