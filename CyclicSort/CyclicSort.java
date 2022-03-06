package CyclicSort;
import java.util.Arrays;

import java.util.*;
public class CyclicSort {
    public static void main(String args[]){
        //int[] arr = {1,3,5,6,9,14,16,18,21,22,23,25,26,29,99};
        int arr[] = {3,5,2,1,4};
        System.out.println("Sorted Array:" + Arrays.toString(cyclicSort(arr)));       
     }
    
     public static int[] cyclicSort(int[] arr){
        int i =0 , end = arr.length -1;
        while(i<=end){
            int correct = arr[i] - 1;
            // if(arr[i]!=arr[correct]){
            //     swap(arr,i,correct);
            // }
            // else 
            //     i++;     
            while(arr[i]!=arr[correct]){
                swap(arr, i, correct);
                correct = arr[i] - 1;
            }
            i++;

        }
        return arr;
     }

     public static void swap(int[] arr, int first, int second){
         int temp = arr[first];
         arr[first] = arr[second];
         arr[second] = temp;
     }
}
