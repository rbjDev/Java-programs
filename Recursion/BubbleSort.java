package Recursion;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){
       int arr[] = {4,3,2,1};
       sort(arr);
       System.out.println("Sorted array:"+ Arrays.toString(arr));
    }

public static void sort(int arr[]){
    for(int i=0;i<arr.length;i++){
        int c=0;
        for(int j =0;j<(arr.length-i-1);j++){
            if(arr[j]>arr[j+1]){
                swap(arr,j,j+1);
                c++;
            }
        }   
        
    }
}

public static void sortRecursive(int arr[],int r,int c){
    if(r==0) return;
    if(c<r){
        if(arr[c]>arr[c+1]){
            swap(arr,c,c+1);
        }
        sortRecursive(arr, r, c+1);
    }
    else{
        sortRecursive(arr, r-1, 0);
    }
}

    public static void swap(int arr[],int i, int j){
        int temp= arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
