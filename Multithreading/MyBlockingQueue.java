package Multithreading;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<T> {
    Queue<T> queue;
    int size;

    MyBlockingQueue(int size){
        this.queue = new ArrayDeque<>(size);
        this.size = size;
    }

    public synchronized void add(T item) throws InterruptedException{
        while(this.queue.size()==size-1){
            this.wait();
        }
        this.queue.add(item);
        this.notifyAll();
    }

    public synchronized T take() throws InterruptedException{
        while(this.queue.size()==0){
            this.wait();
        }
        T item = this.queue.poll();
        this.notifyAll();
        return item;
    }

    public static void main(String args[]){
        MyBlockingQueue<String> myQueue = new MyBlockingQueue<>(5);
        
        Runnable producer = ()->{
            int i =3;
            while(i>0){
                try {
                    System.out.println("Producer thread: "+ Thread.currentThread().getName());
                    myQueue.add("Name-"+i);
                    Thread.sleep(3000);
                    i--;
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }    

        };

        Runnable consumer = ()->{
            int i=2;
            while(i>0){
                try {
                    System.out.println("Deleted:" + myQueue.take());
                    Thread.sleep(4000);
                    i--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Consumer thread: "+ Thread.currentThread().getName());
        };

        Thread p1 = new Thread(producer);
        Thread p2 = new Thread(producer);

        Thread c1 = new Thread(consumer);
        Thread c2 = new Thread(consumer);

        p1.start();
        c1.start();
        p2.start();
        c2.start();



    }
    
}
