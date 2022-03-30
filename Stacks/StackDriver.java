package Stacks;

import java.util.ListIterator;
import java.util.Stack;

public class StackDriver {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(10);
        stack.push(15);
        System.out.println(stack.peek());
        ListIterator<Integer> it = stack.listIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
