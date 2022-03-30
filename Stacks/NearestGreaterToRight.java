package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.util.Stack;

public class NearestGreaterToRight {
    public static void main(String args[]){
        int arr[]={1,3,0,0,1,2,4};
        System.out.println(getNearestGreaterToRight(arr));
    }
    public static List<Integer> getNearestGreaterToRight(int arr[]){
        Stack<Integer> stack = new Stack<>();
        List<Integer> op = new ArrayList<>(arr.length);
        int[] result = new int[arr.length];
        for(int i = arr.length-1;i>=0;i--){
            if(stack.isEmpty()){
                op.add(-1);
                result[i] =-1;
                
            }
            else if(stack.peek()>arr[i]){
                op.add(stack.peek());
                result[i] = stack.peek();
            }
            else{
                while(!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    op.add(-1);
                    result[i] = -1;
                }
                else{
                    op.add(stack.peek());
                    result[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        Collections.reverse(op);
        System.out.println("Result:" + Arrays.toString(result));
        return op;
    }
}
