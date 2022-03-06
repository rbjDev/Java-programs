package library;
import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class BinarySearch {
    public static void main(String[] args) {       
        int arr[] = ArrayInputClass.getArray();       
        System.out.println("Enter element to search:");
        Scanner in = new Scanner(System.in);
        int key = 6;//in.nextInt();
        int foundIndex = binSearch(arr,key);  
        if(foundIndex<0){
            System.out.println("Element not found!!");
        }      
        else{
            System.out.println("Number found at index: "+ foundIndex);
        }
        in.close();
    }

    public static int binSearch(int arr[], int key){
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end-start)/2 ;
        while(start<=mid){
            if(arr[mid] == key)
                return mid;
            else if(key<arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;

    }

    public static int binSearch(int arr[], int key,int start, int end){
        //if(end >= arr.length) end =arr.length - 1;
        while(start<=end){
            int mid = start + (end-start)/2 ;
            if(arr[mid] == key)
                return mid;
            else if(key<arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;

    }
}
