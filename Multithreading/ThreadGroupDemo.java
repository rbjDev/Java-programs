package Multithreading;
/**
 * Ref: https://codezup.com/threadgroup-in-multi-threading-java-with-example/
 */
public class ThreadGroupDemo extends Thread{
    public ThreadGroupDemo(ThreadGroup gp, String name){
        super(gp,name);
    }
    public static void main(String args[]) throws InterruptedException{
        ThreadGroup pg = new ThreadGroup("Parent group");
        ThreadGroup cg = new ThreadGroup(pg,"Child group");
        ThreadGroupDemo t1= new ThreadGroupDemo(pg,"T1");
        ThreadGroupDemo t2= new ThreadGroupDemo(pg,"T2");
        t1.start();
        t2.start();
        System.out.println("Active count:" + pg.activeCount());
        System.out.println("Active group count:" + pg.activeGroupCount());
        pg.list();
        Thread.sleep(500);
        System.out.println("Active count:" + pg.activeCount());
        pg.list();

    } 

    public void run(){
        System.out.println("Thread: " + Thread.currentThread().getName() + " running!");
    }
    
}
