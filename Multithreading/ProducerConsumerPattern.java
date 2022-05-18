package Multithreading;
/**
 * https://www.baeldung.com/java-producer-consumer-problem
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class ProducerConsumerPattern {
    
}

class CustomBlockingQueue<E>{
    private final Queue<E> queue ;
    private final int max;
    private final Object FULL = new Object();
    private final Object EMPTY = new Object();

    CustomBlockingQueue(int size){
        this.max = size;
        queue = new ArrayDeque<>(size);
    }

    public void add(E item){
        synchronized(queue){
            this.queue.add(item);
        }        
    }

    public synchronized E remove(){
       synchronized(queue){
           return queue.poll();
       }
    }

    public boolean isFull(){
        return this.queue.size()==max;
    }

    public boolean isEmpty(){
        return this.queue.size()==0;
    }

    public void waitOnFull() throws InterruptedException{
        synchronized(FULL){
            FULL.wait();
        }
    }

    public void waitOnEMpty() throws InterruptedException{
        synchronized(EMPTY){
            FULL.wait();
        }
    }

    public void notifyOnFull() throws InterruptedException{
        synchronized(FULL){
            FULL.notifyAll();
        }
    }

    public void notifyOnEmpty() throws InterruptedException{
        synchronized(EMPTY){
            EMPTY.notifyAll();
        }
    }
}

class MyProducer<E> extends Thread{
    CustomBlockingQueue<String> queue;

    MyProducer(CustomBlockingQueue<String> q){

        this.queue = q;
    }

    public void run(){
        try {
            this.produce();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void produce() throws InterruptedException{
        while(true){
            String msg = "new";
            while(this.queue.isFull()){
                queue.waitOnFull();
            }
            queue.add(msg);
            queue.notifyOnEmpty();
        }
    }
}

class MyConsumer<E> extends Thread{
    CustomBlockingQueue<String> queue;

    MyConsumer(CustomBlockingQueue<String> q){
        this.queue = q;
    }

    public void run(){
        try {
            this.consume();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void consume() throws InterruptedException{
        while(this.queue.isEmpty()){
            this.queue.waitOnEMpty();
        }
        this.queue.remove();
        this.queue.notifyOnFull();

    }
}
