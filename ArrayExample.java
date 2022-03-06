import java.util.Arrays;

public class ArrayExample {
    public static void main(String args[]){
       int[] arr = new int[5];
       arr[0]=1;
       arr[1]=9;
       int[] barr = {10,9,2,9,7};
       System.out.println(arr[0]);
       for(int i=0; i<barr.length; i++){
        System.out.println(barr[i] + ",");
       } 
       System.out.println(Arrays.toString(barr));
       String names[] =new String[5];
       for(int i=0; i<names.length ; i++){
           names[i] = "Name-" + i ;
       }
       for(String name : names){
           System.out.println(name.charAt(0));
       }

       int[][] array2d = new int [2][3];
       int[][] matrix = {
           {1,2,3},
           {4,5,6},
           {7,8}
       };
       for(int[] a: matrix){
        System.out.println(Arrays.toString(a));
       }
       
     }
}
