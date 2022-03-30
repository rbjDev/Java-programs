package Queue;

public class CustomQueue {
    private int[] data;
    private static final int DEFAULT_SIZE = 10; 
    private int end = -1;

    CustomQueue(){
        this(DEFAULT_SIZE);
    }

    CustomQueue(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        if(end==data.length-1) return true;
        return false;
    }

    public boolean isEmpty(){
        if(end==-1) return true;
        return false;
    }

    public boolean insert(int val){
        if(isFull()){
            return false;
        }
        data[++end] = val;
        return true;

    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty!!");
        }
        int removed = data[end];
        //shift elements by one position to the left
        for(int i =1;i<end;i++){
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }

    public static void main(String[] args) throws Exception{
        CustomQueue q=new CustomQueue();
        q.insert(5);
        q.insert(10);
        q.remove();
        q.remove();
        q.remove();
    }




}
