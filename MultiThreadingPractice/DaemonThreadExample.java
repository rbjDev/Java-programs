package MultiThreadingPractice;

import java.util.Calendar;

public class DaemonThreadExample implements Runnable {
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000); //Simulate some background work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Daemon Thread running!!");
        }
        
    }

    public static void main(String[] args) throws InterruptedException {
        
        Thread userThread = new Thread(()->{
            System.out.println("User thread running!!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("User thread completed!!");
        });

        Thread daemonThread = new Thread(new DaemonThreadExample());
        daemonThread.setDaemon(true);

        daemonThread.start();
        userThread.start();
        userThread.join(); // Main thread waits for the user thread to finish
        System.out.println("Main thread finished. Daemon thread will also be terminated.");
        
    }    

}
