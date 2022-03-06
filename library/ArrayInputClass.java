package library;
import java.util.Scanner;

import java.util.*;
public class ArrayInputClass {
    public static int[] getArray(){
        System.out.println("Enter size of array:");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the array elements:");
        for(int i=0;i<size;i++){
            arr[i] = in.nextInt();
        }
        System.out.println("Array entered is as:"+ Arrays.toString(arr));
        in.close();
        return arr;
    }
}
