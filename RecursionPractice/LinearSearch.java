package RecursionPractice;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] =  {11,5,7,9,10,11,13};
        System.out.println(linearSearchRecursive(arr,arr.length-1,100));
        System.out.println(findAllIndexes(arr, 11, 0));
    }

    private static int linearSearchRecursive(int[] arr,int index, int key) {
        if(index<0) return -1;
        if(arr[index]==key) return index;
        return linearSearchRecursive(arr, index-1, key);
    }

    public static ArrayList<Integer> findAllIndexes(int arr[],int key, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index==arr.length) return list;
        if(arr[index]==key) list.add(index);
        list.addAll(findAllIndexes(arr, key, index+1));
        return list;
    }
}
