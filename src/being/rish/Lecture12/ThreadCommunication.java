package being.rish.Lecture12;

class SharedResouce {
    private int data;
    private boolean hasData;

    public synchronized void produce(int value) {
        while (hasData) {
            try{
                wait();
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized int consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();
        return data;
    }
}

class Producer implements Runnable {
    private SharedResouce resouce;

    public Producer(SharedResouce resouce) {
        this.resouce = resouce;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            resouce.produce(i);
        }
    }
}

class Consumer implements Runnable {
    private SharedResouce resouce;

    public Consumer(SharedResouce resouce) {
        this.resouce = resouce;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            int value = resouce.consume();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResouce resouce = new SharedResouce();
        Thread producerThreead = new Thread(new Producer(resouce));
        Thread consumerThread = new Thread(new Consumer(resouce));

        producerThreead.start();
        consumerThread.start();
    }
}
