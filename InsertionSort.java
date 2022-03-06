import java.util.*;
public class InsertionSort {

    public static void main(String args[]){
       int[] arr = {3,5,6,9,14,16,1,25,26,18,21,22,23,29,99};
       System.out.println("Sorted: " + Arrays.toString(insertionSort(arr)));
      
        
     }

    public static int[] insertionSort(int arr[]){
        for(int i = 1;i < arr.length ; i++){
            int key = arr[i];
            int j= i -1 ;
            while(j>=0 && key< arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] =  key;
        }
        return arr;
    }

    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
      
}


