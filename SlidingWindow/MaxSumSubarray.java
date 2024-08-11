package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class MaxSumSubarray {
    public static void main(String[] args) {
        int arr[] = {100,200,300,400};
        int k =4;
        System.out.println(findMaxSum(arr, k));
    }

    public static int findMaxSum(int arr[], int k){
        int i=0,j=0,n=arr.length;
        int sum = 0, max =Integer.MIN_VALUE;
        while(j<n){
            sum+= arr[j];
            if(j-i+1 == k){
                max = Math.max(max,sum);
                sum-= arr[i];
                i++;
            } 

            j++;
        }
        return max;
    }

    
    public void firstNegativeNumber(int arr[],int k){
        int i=0,j=0,n=arr.length;
        int sum = 0, max =Integer.MIN_VALUE;
        while(j<n){
            
            if(j-i+1 == k){
                max = Math.max(max,sum);
                sum-= arr[i];
                i++;
            } 

            j++;
        }
    }
}
