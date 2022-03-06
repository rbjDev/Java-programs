package CyclicSort;
/**
 * 645. Set Mismatch
Easy

You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.
 */
import java.util.*;
public class LeetCode645 {
    public static void main(String args[]){
        //int arr[] = {9,6,4,2,3,5,7,0,1};
        int arr[] = {1,2,2,4};
        System.out.println("Number that occurs twice and the number that is missing " + Arrays.toString(findErrorNums(arr)));
    }

    public static int[] findErrorNums(int[] nums) {
        int i=0;
        int arr[] = new int[2];
        while(i<nums.length){
            int correctIndex = nums[i]-1;
            if(nums[correctIndex]!=nums[i])
                swap(nums,i,correctIndex);
            else
                i++;
        }
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                arr[0]=nums[i];
                arr[1]=i+1;
                break;
            }
        }
        return arr;
        
    }
    
    public static void swap(int nums[],int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


}
