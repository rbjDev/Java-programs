package Generics;

import java.util.Arrays;
import java.util.List;

public class GenericMethodClass {

    public static <T> void swap(T[] arr,int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T> void printList(List<T> list){
        for(T item : list){
            System.out.println(item);
        }
    }

    public static  void displayList(List<?> list){
        for(Object item : list){
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        // Integer[] intArray = {1, 2, 3, 4};
        // String[] strArray = {"one", "two", "three", "four"};

        // // Swap elements in an integer array
        // swap(intArray, 1, 3);
        // System.out.println(java.util.Arrays.toString(intArray)); // Output: [1, 4, 3, 2]

        // // Swap elements in a string array
        // swap(strArray, 0, 2);
        // System.out.println(java.util.Arrays.toString(strArray)); // Output: [three, two, one, four]

        List<Integer> list1 = Arrays.asList(1,4,5,9);
        printList(list1);

        List<String> list2 = Arrays.asList("abc","bnv","ouuo");
        printList(list2);
    }

}
