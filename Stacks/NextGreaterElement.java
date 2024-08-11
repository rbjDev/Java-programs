package Stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * The Next greater Element for an element x is the first greater element on the right side of x in the array. 
 * Elements for which no greater element exist, consider the next greater element as -1. 
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {4,12,5,3,1,2,5,3,1,2,4,6};
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[arr.length];
        int i = arr.length -1;
        for(;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()) res[i] = -1;
            else    res[i] = stack.peek();
            stack.push(arr[i]);

        }
        System.out.println(Arrays.toString(res));

        Map<Integer,Integer> map = new HashMap<>();
        map.merge(5, 1, Integer::sum);

        TreeMap<Integer, String> countContentMap = new TreeMap<>();
        
        
    }
}
