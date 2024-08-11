package MultiThreadingPractice;

//Extending thread class
class MyThread1 extends Thread{
    public MyThread1(String name){
        super(name);
    }
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Printing from :" + Thread.currentThread().getName() + " - "+ i);
        }
    }
}

public class ThreadingExample {
    public static void main(String[] args) throws InterruptedException {

        //Creating a thread using an instance of Runnable interface
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i=0;i<10;i++){
                    System.out.println("Printing from thread1:" + i);
                }
            }
        });
        //Creating a thread using an instance of Runnable interface - but using lambda
        Thread t2 = new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println("Printing from thread2:" + i);
            }
        });

        MyThread1 t3 = new MyThread1("MyThread3");
        System.out.println("Main thread is executing!!");
        // t1.start();
        // t2.start();
        t3.start();
        System.out.println("Main thread will join t1!!");
        //t1.join();
        System.out.println("Main thread executing!!");
        System.out.println("Main thread has finished executing!!");
    }
}
