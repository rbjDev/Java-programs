package Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadingPractice {

    /**
     * 1. You can create a thread by extending the Thread class and overriding its
     * run method.
     */
    static class MyThread1 extends Thread {
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running!!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " has finished!!");
        }
    }

    /**
     * You can create a thread by implementing the Runnable interface and passing an
     * instance of the implementing class to a Thread object.
     */

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running!!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " has finished!!");
        }
    }

    /**
     * In Java, there are several ways to create threads. The primary methods are:
     * 1. Extending the Thread class
     * 2. Implementing the Runnable interface
     * 3. Implementing the Callable interface
     * 4. Using the ExecutorService framework
     * 
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " has started!!");
        // 1. Extending the Thread Class
        MyThread1 thread1 = new MyThread1();
        thread1.start();
        System.out.println(Thread.currentThread().getName() + " has ended!!");

        // 2. Implementing the Runnable Interface
        Thread threadRunnable = new Thread(new MyRunnable(), "Runnable-thread");
        threadRunnable.start();

        // Using lambda syntax (since Runnable is a functional interface):
        Runnable lambdaRunnable = () -> {
            System.out.println(Thread.currentThread().getName() + " is running!!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " has finished!!");
        };
        Thread lambdaThread = new Thread(lambdaRunnable, "LambdaRunnable");
        lambdaThread.start();

        // 3. Using the ExecutorService Framework with Callable or Runnable
        /**
         * The ExecutorService framework provides a higher-level API for managing
         * threads.
         * You can submit Runnable or Callable tasks to an ExecutorService.
         */
        Callable<String> lambdaCallable = () -> {
            System.out.println(Thread.currentThread().getName() + " is running!!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " has finished!!");
            return "callable thread finished!!";
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(lambdaCallable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}
