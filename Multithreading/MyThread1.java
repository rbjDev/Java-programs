package Multithreading;

public class MyThread1 extends Thread{ //extending Thread
    
    @Override
    public void run(){
        for(int i = 0 ;i <5; i++){
            System.out.println("Child thread!!");
        }
    }

    public static void main(String args[]){
        MyThread1 t = new MyThread1();
        t.start(); // starting of a child thread

        //This part will be executed by main thread
        for(int i = 0;i<5;i++){
            System.out.println("Main thread!!");
        }


        //By implementing Runnable interface
        
        
        
        System.out.println("Main thread!!");
        
        Thread mainT = Thread.currentThread();
        System.out.println("Name of main thread:"+ mainT.getName() + ", Priority:" + mainT.getPriority()); 
        mainT.setName("MyMainThread");
        mainT.setPriority(7);
        MyRunnable r = new MyRunnable();
        Thread t1 = new Thread(r);
        
        System.out.println("Name of main thread:"+ mainT.getName() + ", Priority:" + mainT.getPriority()); 
        t1.start();//child thread started by main thread. Will get the priority of main thread i.e 7
        System.out.println("Priority of child thread:" + t1.getPriority()); 

        while(System.out.printf("Hello World")==null){}

    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Child thread using Runnable !!");
        
    }

}
