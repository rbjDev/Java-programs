package Multithreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueueUsingLockDemo {
    
}

class BlockingQueueViaLock{
    Queue<Integer> q;
    int CAPACITY; 
    Lock lock;
    Condition EMPTY_QUEUE;
    Condition FULL_QUEUE;

    BlockingQueueViaLock(int size){
        q = new ArrayDeque<>(size);
        this.CAPACITY =size;
        this.lock = new ReentrantLock();
        this.EMPTY_QUEUE = lock.newCondition();
        this.FULL_QUEUE = lock.newCondition();
    }

    public void addToQueue(Integer x) throws InterruptedException{
        try{
            while(q.size()==this.CAPACITY){
                this.FULL_QUEUE.await();
            }
            lock.lock();
            this.q.add(x);
            this.EMPTY_QUEUE.signalAll();
        }finally{
           lock.unlock(); 
        }
    }

    public int takeFromQueue() throws InterruptedException{
        try{
            while(q.size()==0){
                this.EMPTY_QUEUE.await();
            }
            lock.lock();
            this.FULL_QUEUE.signalAll();
            return q.peek();

        }finally{
            lock.unlock();
        }
    }
}