package Recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int arr[] = {3,3,3};
        mergeSort(arr, 0, arr.length-1);
        System.out.println("Sorted array:"+ Arrays.toString(arr));
     }

    public static void mergeSort(int arr[],int l, int r){
        if(l<r){
            int mid = l + (r-l)/2 ;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr,l,mid,r);
        }
    }
    public static void merge(int arr[], int l, int mid, int r){
        int lSize = mid-l+1;
        int rSize = r-mid;
        int arr1[] = new int[lSize];
        int arr2[] = new int[rSize];
        
        for(int i=0;i<lSize;i++){
            arr1[i] = arr[l+i];
        }

        for(int i=0;i<rSize;i++){
            arr2[i] = arr[mid+i+1];
        }

        int i=0,j=0;
        int k=l;
        while(i<lSize && j<rSize){
            if(arr1[i]<=arr2[j]){
                arr[k++] = arr1[i++];
            }
            else
                arr[k++] = arr2[j++];
        }

        while(i<lSize){
            arr[k++] = arr1[i++];
        }

        while(j<rSize){
            arr[k++] = arr2[j++];
        }
    }
    
}
