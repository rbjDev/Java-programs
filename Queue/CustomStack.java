package Queue;

public class CustomStack {
   protected int[] data;
   private static final int size = 10; 
   private int top =-1;

   public CustomStack(){
       this.data = new int[size];
   }

   public CustomStack(int size){       
       this.data =  new int[size];
   }

   public int size(){
       return data.length;
   }
   public int peek() throws StackException{
       if(top==-1){
           throw new StackException("Cannot peek into empty stack!");
       }
       return data[top];
   }
   public boolean push(int val) throws StackException{
       if(top == data.length-1){
           System.out.println("Stack Overflow!");
           throw new StackException("Stack empty! Cannot pop!");
       }
       top++;
       data[top] = val;
       return true;
   }

   public int pop() throws StackException{
       if(top==-1){
           System.out.println("Empty stack!");
           throw new StackException("Stack empty! Cannot pop!");
       }
       int val = data[top];
       top--;
       return val;
   }

   public boolean isFull(){
       if(top == data.length-1) return true;
       return false;
   }

   public static void main(String args[]) throws StackException{
       CustomStack stack = new CustomStack();
       stack.push(5);
       stack.push(5);
       stack.pop();
       stack.pop();
       stack.pop();


   }
}
