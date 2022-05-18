package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Ref: https://www.callicoder.com/java-executor-service-and-thread-pool-tutorial/

public class ExecutorServiceTest {
    public static void main(String args[]){
        System.out.println("Inside: " + Thread.currentThread().getName());
        //Creating exececutor service with only on thread
        /**
         * ExecutorService exService = Executors.newSingleThreadExecutor();
        //Creating a Runnable
        Runnable r = () -> {
            try {
                extracted();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        };

        exService.submit(r);
         */
        
        ExecutorService exService = Executors.newFixedThreadPool(2);
        Runnable r1 = () -> {
            extracted();;
        };
        Runnable r2 = () -> {
            print(3);
        };
        Runnable r3 = () -> {
            print(7);
        };
        exService.submit(r1);
        exService.submit(r2);
        exService.submit(ExecutorServiceTest::extracted);
        exService.shutdown();
    }

    private static void extracted()  {
        for(int i=1;i<5;i++){
            System.out.println("Inside : " + Thread.currentThread().getName() + " value: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private static void print(int n){
        System.out.println("Inside : " + Thread.currentThread().getName() + " value: " + n);
    }
}
