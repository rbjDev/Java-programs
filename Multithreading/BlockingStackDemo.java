package Multithreading;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingStackDemo {
    
}
class BlockingStack{
    Stack<Integer> stack;
    int CAPACITY;
    ReentrantLock lock ;
    Condition stackEmptyCondition;
    Condition stackFullCondition;

    BlockingStack(int size){
            this.stack = new Stack<>();
            this.CAPACITY = size;
            this.lock = new ReentrantLock();
            this.stackEmptyCondition = lock.newCondition();
            this.stackFullCondition = lock.newCondition();
    }

    public void pushToStack(Integer x) throws InterruptedException{
        try{
            lock.lock();
            while(stack.size()==this.CAPACITY){
                stackFullCondition.await();
            }
            stack.push(x);
            stackEmptyCondition.signalAll();
        }
        finally{
            lock.unlock();
        }

    }

    public int popFromStack(){
        try{
            lock.lock();
            while(stack.size()==0){
                try {
                    stackEmptyCondition.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            stackFullCondition.signalAll();
            return stack.pop();
        }finally{
            lock.unlock();
        }
    }


}
