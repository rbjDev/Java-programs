package Recursion;
import java.util.*;
public class LinearSearchRecursive {
    static ArrayList<Integer> indexList = new ArrayList<>();
     public static void main(String[] args){
        int arr[] ={1,7,3,9,2,3,8};
        System.out.println("Search 5:"+ search(arr, 5, 0));
        // findAllIndex(arr, 3, 0);
        // System.out.println("Search all occurences of 3:"+ indexList);
        System.out.println("Search all occurences of 3:"+ findAllIndexVer2(arr, 3, 0, indexList));

    }
    public static int search(int arr[], int target, int index){
        if(index==arr.length) return -1;
        if(arr[index]==target) return index;
        return search(arr, target, index+1);

    }
    public static void findAllIndex(int arr[],int target,int index){
        if(index==arr.length) return ;
        if(arr[index]==target) indexList.add(index);
        findAllIndex(arr, target, index+1);

    }

    public static List<Integer> findAllIndexVer2(int arr[],int target,int index,ArrayList<Integer> indexList){
        if(index==arr.length) return indexList ;
        if(arr[index]==target) indexList.add(index);
        return findAllIndexVer2(arr, target, index+1,indexList);

    }


}
