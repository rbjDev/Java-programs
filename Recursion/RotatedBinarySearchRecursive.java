package Recursion;

public class RotatedBinarySearchRecursive {
    public static void main(String[] args){
        int arr[] ={5,0,2,3,4};
        System.out.println("Search 3:"+ rotatedBinarysearch(arr, 3, 0, arr.length-1));
    }

    public static  int rotatedBinarysearch(int arr[], int target, int start, int end){
        if(start>end) return -1;
        int mid = start + (end-start)/2;
        if(arr[mid]==target) return mid;
        else if(arr[start]<=arr[mid]){
            if(arr[start]<=target && target<=arr[mid]){
                return rotatedBinarysearch(arr, target, start, mid-1);
            } 
            else {
                return rotatedBinarysearch(arr, target, mid-1, end);
            }
        }
        else if (arr[mid]<=target && target<=arr[end])
            return rotatedBinarysearch(arr, target, mid+1, end);
        else 
            return rotatedBinarysearch(arr, target, start, mid-1);
            

    } 
}
