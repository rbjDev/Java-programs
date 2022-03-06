/*
 https://www.youtube.com/watch?v=W9QJ8HaRvJQ&t=12044s
 Ceiling of a number in an array : Smallest number greater than the target number in an array 
 Floor of a number in an array : Largest number greater than the target number in an array
*/

import library.*;
public class CeilingNumber {
    public static void main(String args[]){
        int[] arr = ArrayInputClass.getArray();
        int target = 15;
        System.out.println("Ceiling of " + target + ":" + getCeiling(arr,target) );
        System.out.println("Floor of " + target + ":" + getFloor(arr,target) );
    }

    public static int getFloor(int arr[], int target){
        int start = 0;
        int end = arr.length - 1;
        
        if(arr[0] > target)
        return -1;
        while(start<=end){
            int mid = start + (end-start)/2 ;
            if(arr[mid] == target)
                return arr[mid];
            if(target<arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return arr[end];
    }

    public static int getCeiling(int arr[], int target){
        int start = 0;
        int end = arr.length - 1;
       
        // if(arr[arr.length - 1] < target)
        // return -1;
        while(start<=end){
            int mid = start + (end-start)/2 ;
            if(arr[mid] == target)
                return arr[mid];
            else if(target<arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return arr[start];
    }
}
