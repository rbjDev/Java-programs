package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        int result[] = new int[size-k+1];
        int ri = 0; 
        Deque<Integer> deque =  new ArrayDeque<>();
        for(int i=0; i<size ; i++){
            if(!deque.isEmpty() && deque.peek()==i-k){
                deque.poll();
            }

            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i >= k-1)
                result[ri++] = nums[deque.peek()];
        }
        return result;

    }
}
