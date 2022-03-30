package Multithreading;

public class ThreadJoinDemo extends Thread {
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Child thread");
            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e){}        }

    }
    public static void main (String args[]) throws InterruptedException{
        ThreadJoinDemo t = new ThreadJoinDemo();
        t.start();
        t.join(); // main thread will wait for child thread to finish
        for(int i=0;i<10;i++){
            System.out.println("Main thread!!"); //Since child thread has yielded the main thread will execute first then child will resume.
        }

    }
}
