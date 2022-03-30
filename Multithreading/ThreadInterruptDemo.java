package Multithreading;

public class ThreadInterruptDemo extends Thread{
    public void run() { //child thread is running the run() method        
        try{
            
            for(int i=0;i<5;i++){
                System.out.println("Child thread!!");
                Thread.sleep(2000);
            }
        }catch(InterruptedException e){
            System.out.println("Child got interrupted!");
        }
    }
    public static void main(String[] args ) throws InterruptedException{
        
        ThreadInterruptDemo t = new ThreadInterruptDemo();
        t.start();
        t.interrupt();
        for(int i=0;i<5;i++){
            Thread.sleep(2000);
            System.out.println("Main thread :" + i);
        }
    }
}
