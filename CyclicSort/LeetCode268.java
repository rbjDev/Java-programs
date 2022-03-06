package CyclicSort;
/**
 * https://leetcode.com/problems/missing-number/
 * 268. Missing Number
Easy

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */
import java.util.*;
public class LeetCode268 {
    public static void main(String args[]){
        //int arr[] = {9,6,4,2,3,5,7,0,1};
        int arr[] = {0,1};
        System.out.println("Missing number:" + missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        /**
        Step 1: Do cyclic sort on array
        Step 2: Find mismatch index
        */       
        
        int i =0 ;
        while(i< nums.length){
            int correct = nums[i] ;
            if(nums[i]<nums.length && nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }
            else 
                i++;     
        } 
        for(i= 0 ;i<nums.length;i++){
             if(nums[i]!=i) return i;
         }
         return nums.length;
    }
  
     public static void swap(int[] arr, int first, int second){
         int temp = arr[first];
         arr[first] = arr[second];
         arr[second] = temp;
     }

     public int missingNumber2ndApproach(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) { return i; }
        }
        return nums.length;
    }

    public int missingNumberBestApproach(int[] nums){
        int n=nums.length;
    
    int totalSum=((n+1)*n)/2;
    int sum=0;
    for(int i=0 ;i < n ;i++){
        sum+=nums[i];
    }
    
    return totalSum-sum;
    }

    
}
