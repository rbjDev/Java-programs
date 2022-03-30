package Stacks;
/**
 * LeetCode 901
 * https://leetcode.com/problems/online-stock-span/
 */
import java.util.*;
public class StockSpan {
    public static void main(String args[]){
        int arr[]={100,80,60,70,60,75,85};
        System.out.println(getStockSpan(arr));
    }

    public static int[] getStockSpan(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i =0;i<arr.length;i++){
            if(stack.isEmpty()){                
                result[i] =1;                
            }
            else if(arr[stack.peek()] > arr[i]){                
                result[i] = i - stack.peek();
            }
            else{
                while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){                    
                    result[i] = i + 1;
                }
                else{                    
                    result[i] = i - stack.peek();
                }
            }
            stack.push(i);
        }
        
        System.out.println("Result:" + Arrays.toString(result));
        return result;
    }
}
