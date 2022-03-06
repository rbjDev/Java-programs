package Recursion;
/**
 * Check if array is sprted or not.
 */
public class CheckSortedArray {
    public static void main(String args[]){
        int arr[] = {1,4,90,9};
        System.out.println("Array sorted:" + check(arr,0));
    }

    public static boolean check(int arr[],int index){
        if(index==arr.length-1) return true;
        return arr[index] < arr[index+1] && check(arr, index+1); 
    }
}
