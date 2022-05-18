package Multithreading;

import java.util.Calendar;
import java.util.Date;

/**
 * https://www.baeldung.com/java-threadlocal
 */
public class ThreadLocalDemo {
    public static void main(String args[]){
        ThreadExm1 t1 = new ThreadExm1();
        t1.start();

        ThreadExm1 t2 = new ThreadExm1();
        t2.start();
    }    
}
class ThreadExm1 extends Thread{
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public void run(){
        threadLocal.set(Thread.currentThread().getName() + ":" + Calendar.getInstance().getTime());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadLocal.get());
        threadLocal.set(Thread.currentThread().getName() + ":" + Calendar.getInstance().getTime());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        System.out.println(threadLocal.get());
    }
}
