import java.util.*;
import java.util.concurrent.*;

// Basic thread using Thread class
class MyThread extends Thread {
    public void run() {
        System.out.println("Running Thread class: " + Thread.currentThread().getName());
    }
}

// Basic thread using Runnable
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Running Runnable: " + Thread.currentThread().getName());
    }
}

// Simple counter (for synchronization demo)
class Counter {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}

// Producer Consumer (simple version)
class Buffer {
    Queue<Integer> queue = new LinkedList<>();
    int size = 3;

    public synchronized void produce(int val) throws Exception {
        while (queue.size() == size) {
            wait();
        }
        queue.add(val);
        System.out.println("Produced: " + val);
        notify();
    }

    public synchronized void consume() throws Exception {
        while (queue.isEmpty()) {
            wait();
        }
        int val = queue.poll();
        System.out.println("Consumed: " + val);
        notify();
    }
}

// Main class
public class Main {

    public static void main(String[] args) throws Exception {

        // 1. Thread class
        MyThread t1 = new MyThread();
        t1.start();

        // 2. Runnable
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        // 3. Synchronization
        Counter c = new Counter();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("Final Count: " + c.count);

        // 4. Producer Consumer
        Buffer b = new Buffer();

        Thread p = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) b.produce(i);
            } catch (Exception e) {}
        });

        Thread con = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) b.consume();
            } catch (Exception e) {}
        });

        p.start();
        con.start();

        p.join();
        con.join();

        // 5. ExecutorService (simple thread pool)
        ExecutorService ex = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 3; i++) {
            int num = i;
            ex.execute(() -> {
                System.out.println("Task " + num + " by " + Thread.currentThread().getName());
            });
        }

        ex.shutdown();
    }
}