package Multithreading;

public class DeadlockDemo {
    private final Object res1 = new Object();
    private final Object res2 = new Object();

    public static void main(String args[]){
        DeadlockDemo obj = new DeadlockDemo();

        Runnable r1 = ()->{
            synchronized(obj.res1){
                System.out.println(Thread.currentThread().getName() + "acquired lock for res1.. Will now sleep!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "woke up!! Now will try to acquire lock on res2");
                
                synchronized(obj.res2){
                    System.out.println(Thread.currentThread().getName() + "Holding lock for res1 and res2");
                }
            }
        };

        Runnable r2 = ()->{
            synchronized(obj.res2){
                System.out.println(Thread.currentThread().getName() + "acquired lock for res1.. Will now sleep!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "woke up!!Now will try to acquire lock on res1");  
                synchronized(obj.res1){
                    System.out.println(Thread.currentThread().getName() + "Holding lock for res1 and res2");
                }
            }
        };

        Thread t1= new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }    
    
}
