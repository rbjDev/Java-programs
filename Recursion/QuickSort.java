package Recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int arr[] = {13,3,31,2,7,99};
        quickSort(arr, 0, arr.length-1);
        System.out.println("Sorted array:"+ Arrays.toString(arr));
    }

    public static void quickSort(int arr[],int l, int r){
        if(l<r){
            int pivot = partition(arr,l,r);
            quickSort(arr, l, pivot-1);
            quickSort(arr, pivot+1, r);
        }
    }

    public static int partition(int arr[],int l ,int r){
        int i = l-1;
        int j = l;
        while(j<r){
            if(arr[j]<=arr[r]){
                i++;
                swap(arr,i,j);
            }
            j++;
        }
        swap(arr,i+1,r);
        return i+1;
    }

    public static void swap(int arr[],int i, int j){
        int temp= arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
