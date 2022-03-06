/*https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
34. Find First and Last Position of Element in Sorted Array
Medium

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

*/
import java.util.*;
public class LeetCode34 {

    public static void main(String args[]){
        int[] nums = {5,5,5,5,6,8,8,8,8,8,8,8,9,9,9,9,9,10,10};
        int target = 8;
        System.out.println("First and last occurence: " + Arrays.toString(searchRange(nums, target)));    
        
    }

    public static int[] searchRange(int[] nums, int target) {
       int result[] = {-1,-1};
       int first = search(nums,target,true);
       int last = search(nums,target,false);
       result[0] = first;
       result[1] = last;  
       return result;
    }

    public static int search(int nums[], int target, boolean searchFirst){
        int start = 0;
        int end = nums.length - 1;   
        int ans = -1;  
       
        while(start<=end){
            int mid = start + (end-start)/2 ;
            if(target<nums[mid])
                end = mid - 1;
            else if(target > nums[mid])
                start = mid + 1; 
            else{
                ans = mid;
                if(searchFirst){
                    end = mid -1;
                } 
                else
                    start = mid + 1;
            }

        }
        return ans;
    }

    
    
}
