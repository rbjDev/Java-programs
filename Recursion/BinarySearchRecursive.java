package Recursion;

public class BinarySearchRecursive {
    public static void main(String[] args){
        int arr[] ={1,3,5,7,9,11,18};
        System.out.println("Search 18:"+ search(arr, 18, 0,arr.length-1));
    }
    public static  int search(int arr[], int target, int start, int end){
        if(start>end) return -1;
        int mid = start + (end-start)/2;
        if(arr[mid]==target) return mid;
        else if(target<arr[mid])
            return search(arr, target, start, mid-1);
        else
            return search(arr, target, mid+1, end);

    } 
}
