/**
 * https://leetcode.com/problems/find-in-mountain-array/
 * LeetCode 1095. Find in Mountain Array
 */
public class LeetCode1095 {
    public static void main(String args[]){
        //int[] arr = {1,3,5,6,9,14,16,18,21,22,23,25,26,29,99};
        int arr[] = {0,5,3,1};
        int target = 1;
        System.out.println("First index of target:" + search(arr,target) );
     }

     public static int search(int[] arr, int target){
         int peakIndex = peakIndexInMountainArray(arr);
         int leftIndex = orderAgnosticSearch(arr, target,0,peakIndex);
         if(leftIndex!= -1) return leftIndex;
         return orderAgnosticSearch(arr, target, peakIndex+1,arr.length-1);

     }

     public static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end =arr.length - 1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid]<arr[mid+1])
                start = mid+1; //we are in ascending part of array hence look right
            else {
                end = mid; // we are in the descending part of array, this maybe an ans, but look left as well
            }             
                
        }
        //in the end start==end because of two checks above. hence return start or end
        return start;
    }  
    
    public static int orderAgnosticSearch(int[] arr, int target,int start, int end){
        //int start = 0 , end = arr.length - 1;
        boolean isAsc = arr[start] <arr[end];
        while(start<=end){
            int mid = start + (end-start)/2 ;
            if(arr[mid] <target){
                if(isAsc) start = mid+1;
                else end = mid - 1;
            }
            else if(arr[mid] > target){
               if(isAsc) end= mid -1;
               else start = mid + 1;
            }
            else 
               return mid;
        }
        return -1;

    }
    
}
