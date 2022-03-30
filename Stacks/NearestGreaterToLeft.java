package Stacks;
import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToLeft {
    public static void main(String args[]){
        int arr[]={1,9,8,2,3};
        System.out.println(getNearestGreaterToLeft(arr));
    }
    public static int[] getNearestGreaterToLeft(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i =0;i<arr.length;i++){
            if(stack.isEmpty()){                
                result[i] =-1;                
            }
            else if(stack.peek()>arr[i]){                
                result[i] = stack.peek();
            }
            else{
                while(!stack.isEmpty() && stack.peek()<=arr[i]){
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
