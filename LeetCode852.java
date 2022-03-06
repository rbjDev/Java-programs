/**
 *LeetCode: 852. Peak Index in a Mountain Array
  LeetCode: 162: 162. Find Peak Element
Easy

Let's call an array arr a mountain if the following properties hold:

    arr.length >= 3
    There exists some i with 0 < i < arr.length - 1 such that:
        arr[0] < arr[1] < ... arr[i-1] < arr[i]
        arr[i] > arr[i+1] > ... > arr[arr.length - 1]

Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 */
public class LeetCode852 {
    public static void main(String args[]){
        int[] arr = {1,3,5,6,9,14,16,18,21,22,23,25,26,29,99};
        
        System.out.println("Peak Index:" + peakIndexInMountainArray(arr) );
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

}
