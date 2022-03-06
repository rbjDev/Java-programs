import library.*;
public class SearchInfiniteArray {

     public static void main(String args[]){
        int[] nums = {1,3,5,6,9,14,16,18,21,22,23,25,26,29,99};
        int target = 99;
        System.out.println("Output:" + search(nums, target));
     }

     public static int search(int[] nums, int target){
         int start = 0, end = 1;
         int windowSize = 2;
         while(nums[end]<target){
             windowSize = windowSize * 2;
             start = end + 1;
             end = start + windowSize - 1;
         }
        return BinarySearch.binSearch(nums, target, start, end);
     }

}
