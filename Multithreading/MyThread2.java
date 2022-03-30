package Multithreading;

public class MyThread2 extends Thread {

    public void run(){
        for(int i= 0;i<10;i++){
            System.out.println("Child thread!");
            Thread.yield();
        }
    }
    public static void main(String[] args){
        MyThread2 t = new MyThread2();
        t.start();
        for(int i=0;i<10;i++){
            System.out.println("Main thread!!"); //Since child thread has yielded the main thread will execute first then child will resume.
        }
    }

    
}

