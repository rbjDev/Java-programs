package Queue;
/**
 * 641. Design Circular Deque
 * https://leetcode.com/problems/design-circular-deque/
 */
public class CircularDeque {
    private int[] data;
    private int front =-1;
    private int rear = -1;

    public CircularDeque(int k) {
        data = new int[k]; 
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(front==-1){
            front=0;            
        }
        rear = (rear+1)% data.length;
        data[rear] = value;
        return true;  
    }
    
    public boolean deleteFront() {
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
    
    public boolean deleteLast() {
        
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return data[front]; 
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return data[rear];
    }
    
    public boolean isEmpty() {
        return front==-1; 
    }
    
    public boolean isFull() {
        if((front==0 && rear==data.length-1) || rear+1==front) return true;
        return false;
    } 
    
}
