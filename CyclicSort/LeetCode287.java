package CyclicSort;
import java.util.*;
public class LeetCode287 {
    public static void main(String args[]){
        //int arr[] = {9,6,4,2,3,5,7,0,1};
        int arr[] = {1,3,4,2,2};
        System.out.println("Duplicate Number " + findDuplicateNumber(arr));
    }

    public static int findDuplicateNumber(int[] nums) {
        int i=0;
        int size = nums.length;
        while(i<nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i]!= nums[correctIndex] ){
                swap(nums,i,correctIndex);
            }
            else
                i++;
        }   
        System.out.println("Array after cyclic sort:" + Arrays.toString(nums));
        
        for( i= 0 ; i<nums.length ; i++){
            if(nums[i]!= i+1)
               return nums[i];
        }
        return -1;
        
    }
    
    
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =  temp;
    }

    //Solution in O(nlogn) without altering the array
    public int findDuplicate(int[] nums) {
        // 'low' and 'high' represent the range of values of the target        
        int low = 1, high = nums.length - 1;
        int duplicate = -1;
        
        while (low <= high) {
            int cur = (low + high) / 2;

            // Count how many numbers in 'nums' are less than or equal to 'cur'
            int count = 0;
            for (int num : nums) {
                if (num <= cur)
                    count++;
            }
            
            if (count > cur) {
                duplicate = cur;
                high = cur - 1;
            } else {
                low = cur + 1;
            }
        }
        return duplicate;
 }
}
