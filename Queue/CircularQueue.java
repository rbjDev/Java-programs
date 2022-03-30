package Queue;
/**
 * LeetCode 622. Design Circular Queue
 * https://leetcode.com/problems/design-circular-queue/
 */
public class CircularQueue {
    private int[] data;
    private int front =-1;
    private int rear = -1;

    public CircularQueue(int k) {
        data = new int[k];    
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        if(front==-1){
            front=0;            
        }
        rear = (rear+1)% data.length;
        data[rear] = value;
        return true;        
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(front==rear){
            front=-1;
            rear=-1;
        }
        else{
            front = (front + 1)% data.length;
        }
        return true;

    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return data[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return data[rear];
    }
    
    public boolean isEmpty() {
        if(front==-1) return true;
        return false;
    }
    
    public boolean isFull() {
        if((front==0 && rear==data.length-1) || rear+1==front) return true;
        return false;
        
    }
}
