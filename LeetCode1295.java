import java.util.*;
public class LeetCode1295 {
    public static void main(String args[]){
        System.out.println("Enter 5 numbers:");
        int[] arr =new int[5];
        Scanner scanner = new Scanner(System.in);
        for(int i =0; i<5 ;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println("Array is:"+ Arrays.toString(arr));
        System.out.println("Count for numbers with even digits:"+ findNumbers(arr));
    }

    // public int findNumbers(int[] nums) {
    //     int count=0;
    //     for(int num: nums){
    //         if(hasEvenDigits(num)==true)
    //             count++;
    //     }
    //     return count;
    // }
    // public boolean hasEvenDigits(int num){
    //     if(num<0)
    //         num= -1 * num;
    //     int digits = (int)(Math.log10(num) + 1);
    //     if(digits%2 == 0)  
    //         return true ;
    //     return false;
        
    // }
    //Most optimized solution
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int el: nums) {
			// log10(number) + 1 returns the number of digits
			// & bitwise operator used to find if the number is even or not
            if ((((int) Math.log10(el) + 1) & 1) == 0) {
                count++;
            }
        }
        return count;
    }
}
