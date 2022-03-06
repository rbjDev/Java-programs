package CyclicSort;
/**
 * LeetCode-41. First Missing Positive
Hard

Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.
 */
public class LeetCode41 {

    public static void main(String args[]){
        //int arr[] = {9,6,4,2,3,5,7,0,1};
        int arr[] = {3,4,-1,1};
        System.out.println("Missing first positive Number " + firstMissingPositive(arr));
    }
    public static int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct = nums[i] - 1;
            if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[correct] )
                swap(nums,i,correct);
            else
                i++;
        }
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
    
    public static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
