package library;

import javax.lang.model.util.ElementScanner6;

public class OrderAgnosticBinarySearch {
    public static void main(String args[]){
        //int[] arr = {1,3,5,6,9,14,16,18,21,22,23,25,26,29,99};
        int arr[] = {20,19,17,16,15,9,7,5,2};
        int target = 2;
        System.out.println("Found at index:" + orderAgnosticSearch(arr,target) );
     }
     public static int orderAgnosticSearch(int[] arr, int target){
         int start = 0 , end = arr.length - 1;
         boolean isAsc = arr[0] <arr[end];
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
