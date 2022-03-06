import java.util.*;
public class ArrayReverse {
    public static void main(String args[]){
        System.out.println("Enter the array elements:");
        Scanner in = new Scanner(System.in);
        int[] array = new int[6];
        for(int i=0;i<6;i++){
            array[i] = in.nextInt();
        }
        System.out.println("The array is:" + Arrays.toString(array));

        array =  reverse(array);
        System.out.println("The reversed array is: " + Arrays.toString(array));
        Math.log10(5);
    }

    public static int[] reverse(int[] arr){
        int mid = arr.length/2;
        for(int i = 0 ; i<mid ; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }
}
