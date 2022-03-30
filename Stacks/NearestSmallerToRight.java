package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToRight {
    public static void main(String args[]){
        int arr[]={4,5,2,10,8};
        System.out.println(getNearestSmallerToRight(arr));
    }
    public static int[] getNearestSmallerToRight(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i =arr.length-1;i>=0;i--){
            if(stack.isEmpty()){                
                result[i] =-1;                
            }
            else if(stack.peek()<arr[i]){                
                result[i] = stack.peek();
            }
            else{
                while(!stack.isEmpty() && stack.peek()>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){                    
                    result[i] = -1;
                }
                else{                    
                    result[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        
        System.out.println("Result:" + Arrays.toString(result));
        return result;
    }
}
