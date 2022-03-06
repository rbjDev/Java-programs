/**https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 33. Search in Rotated Sorted Array
Medium

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
 */
public class LeetCode33 {
    public static void main(String args[]){
        //int[] arr = {1,3,5,6,9,14,16,18,21,22,23,25,26,29,99};
        int arr[] = {1};
        int target = 7;
        System.out.println("Pivot in array:" + getPivot(arr) );
        System.out.println("Target found at : " + search(arr, target));
     }

     public static int search(int[] arr, int target){
        int pivot = getPivot(arr); // Here pivot is the largest element
        if(pivot==-1) return binSearch(arr, target, 0, arr.length-1);
        if(arr[pivot]==target) return pivot;
        if(arr[0] > target) return binSearch(arr, target, pivot+1, arr.length - 1);
        else return binSearch(arr, target, 0, pivot - 1);
     }

     public static int getPivot(int[] arr){
        int start = 0 , end =arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid<end && arr[mid] > arr[mid+1]) return mid;
            if(mid>start && arr[mid-1] > arr[mid]) return mid-1;
            if(arr[mid] <= arr[start]) 
                end = mid - 1; 
            else start = mid + 1;
        } 
        return -1;
     }

     public static int binSearch(int arr[], int key,int start, int end){
        //if(end >= arr.length) end =arr.length - 1;
        while(start<=end){
            int mid = start + (end-start)/2 ;
            if(arr[mid] == key)
                return mid;
            else if(key<arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;

    }
}
