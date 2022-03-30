package Multithreading;

public class ThreadInterruptionDemo extends Thread {
    public static Thread mt; //thread to ref to main thread

    public void run() { //child thread is running the run() method
        if(mt!=null)
        try{
            mt.join(); //child thread is calling join on main thread, hence it will wait for main thread to complete
            for(int i=0;i<5;i++){
                System.out.println("Child thread!!");
            }
        }catch(InterruptedException e){}
    }
    public static void main(String[] args ) throws InterruptedException{
        ThreadInterruptionDemo.mt = Thread.currentThread();
        ThreadInterruptionDemo t = new ThreadInterruptionDemo();
        t.start();
        for(int i=0;i<5;i++){
            Thread.sleep(2000);
            System.out.println("Main thread :" + i);
        }
    }
    
}
