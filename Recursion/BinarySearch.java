package Recursion;

public class BinarySearch {
    public static void main(String args[]){
        int[] arr = {3,5,6,9,14,16,25,38,87};
        System.out.println("Searc result:" + binSearch(arr,38,0,arr.length-1));
    }  
    public static int binSearch(int arr[],int target, int s, int e){
        if(s>e) return -1;
        int m = s + (e-s)/2;
        if(arr[m]==target)
        return m;
        if(target<arr[m]){
            return binSearch(arr, target, s, m-1);
        }
        return binSearch(arr, target, m+1, e);

    }
}
