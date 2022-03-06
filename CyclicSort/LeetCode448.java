package CyclicSort;
/** https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * LeetCode-448. Find All Numbers Disappeared in an Array
Easy

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 */
import java.util.*;
public class LeetCode448 {
    public static void main(String args[]){
        //int arr[] = {9,6,4,2,3,5,7,0,1};
        int arr[] = {4,3,2,7,8,2,3,1};
        System.out.println("Missing numbers:" + findDisappearedNumbers(arr));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
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
        System.out.println("Array after cyclic sort:" + Arrays.toString(nums));
        List<Integer> list = new ArrayList<Integer>();
        for( i= 0 ; i<nums.length ; i++){
            if(nums[i]!= i+1)
                list.add(i+1);
        }
        return list;
        
    }
    
    // public void cyclicSort(int[] nums){
    //     int i=0;
    //     int size = nums.length;
    //     while(i<nums.length){
    //         int correctIndex = nums[i] - 1;
    //         if(nums[i]!= nums[correct] ){
    //             swap(nums,i,correct);
    //         }
    //         else
    //             i++;
    //     }
    // }
    
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =  temp;
    }
}
