package CyclicSort;
/**
 * 442. Find All Duplicates in an Array
Medium

Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.
 */
import java.util.*;
public class LeetCode442 {
    public static void main(String args[]){
        //int arr[] = {9,6,4,2,3,5,7,0,1};
        int arr[] = {4,3,2,7,8,2,3,1};
        System.out.println("All the integers that appears twice " + findDuplicates(arr));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int i=0;
        int size = nums.length;
        while(i<nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i]!= nums[correctIndex] ){
                swap(nums,i,correctIndex);
            }
            else
                i++;
        }   
        
        List<Integer> list = new ArrayList<Integer>();
        for( i= 0 ; i<nums.length ; i++){
            if(nums[i]!= i+1)
                list.add(nums[i]);
        }
        return list;
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =  temp;
    }
    
}
