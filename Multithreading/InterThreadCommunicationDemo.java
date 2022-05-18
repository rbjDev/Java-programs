package Multithreading;

public class InterThreadCommunicationDemo {
    // public static void main(String args[]) throws InterruptedException{
    //     ThreadB b = new ThreadB();
    //     b.start();
    //     b.join();
    //     System.out.println("Value of total:"+ b.total);
    // }

    public static void main(String args[]) throws InterruptedException{
        ThreadB b = new ThreadB();
        b.start();
        synchronized(b){
            System.out.println("Main thread got lock on object b and trying to call wait method!");
            b.wait(10000); // main thread will release lock on object b and wait indefinitely until it gets notified
            System.out.println("Main thread got notified and lock on object b!!");
            System.out.println("Value of total:"+ b.total);
        }
        
    }
}

class ThreadB extends Thread{
    int total=0;
    public void run(){
        
        synchronized(this){
            System.out.println("Child thread starts calculation!");
            for(int i=1;i<=100;i++){
                total+=i;
            }
            System.out.println("Child thread giving notification!");
            this.notify();
        }     

    }
}
