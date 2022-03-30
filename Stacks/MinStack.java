package Stacks;

import java.util.Stack;

public class MinStack {
    static Stack<Integer> s1;
    static Stack<Integer> s2;

    public static void main(String[] args){
        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
        stack.pop();
        stack.getMin();
        stack.pop();
        stack.getMin();
        stack.pop();
        System.out.println(stack.getMin());
    }
    
    public MinStack(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public static  void push(int val){
        s1.push(val);
        if(s2.isEmpty() || val <= s2.peek()){
            s2.push(val);
        }
    }

    public static void pop(){
        if(s1.isEmpty()) return;
        if(s1.peek().equals(s2.peek())){
            s1.pop();
            s2.pop();
        }
        else{
            s1.pop();
        }
        
    }

    public static int top() {
        return s1.peek();
    }
    
    public static int getMin() {
        return s2.peek();
    }

}
