package Queue;

//import javax.xml.bind.annotation.XmlElement.DEFAULT;

public class GenericQueueUsingArray<T> {
    private T[] data; 
    private static final int DEFAULT_SIZE =3;
    private int front =-1;
    private int rear = -1;

    GenericQueueUsingArray(int size){
        this.data = (T[]) new Object[size];
    }

    GenericQueueUsingArray(){
        this(DEFAULT_SIZE);
    }

    public boolean isFull(){
        if(rear==data.length-1) return true;
        return false;
    }
    public boolean insert(T val){
        if(isFull()) return false;
        if(front==-1){
            front++;            
        }
        data[++rear] = val;
        return true;
        
    }

    public boolean isEmpty(){
        if(front==-1){
            return true;
        }
        return false;
    }
    public T remove() throws Exception{
        if(isEmpty()) {
            throw new Exception("Queue empty! Cannot remove!");
        }
        T val = data[front];
        if(rear==front){
            rear=-1;
            front=-1;
        }
        else{
            front++;
        }
        return val;
        
    }

    public T peek(){
        return data[front];
    }

    public static void main(String[] args) throws Exception{
        GenericQueueUsingArray<Integer> q = new GenericQueueUsingArray<>();
        q.insert(6);
        q.insert(10);
        q.insert(10);
        System.out.println(q.insert(19));
        q.remove();
        System.out.println("Peek:"+ q.peek());

    }



}
