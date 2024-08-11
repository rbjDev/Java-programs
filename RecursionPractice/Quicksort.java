package RecursionPractice;

import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
    
        int arr[] = {1,3,6,19,23,31};
        performQuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void performQuickSort(int arr[],int s, int e){
        if(s>e) return;
        int pivot = partition(arr,s,e);
        performQuickSort(arr, s, pivot-1);
        performQuickSort(arr, pivot+1 ,e);
    }

    public static int partition(int arr[], int s, int e){
        int smallEnd= s;
        int lb = s;
        for(int largeEnd=lb; largeEnd<e; largeEnd++){
            if(arr[lb] > arr[largeEnd+1]){
                smallEnd++;
                swap(arr,smallEnd,largeEnd+1);
            }
        }
        swap(arr,lb,smallEnd);
        return smallEnd;

    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
