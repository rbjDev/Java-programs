package RecursionPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsBest {
    
    static List<List<Integer>> result = new ArrayList<>();
    
    public static void main(String[] args) {
        int [] nums ={1,2,2};//[4,4,4,1,4]
        Arrays.sort(nums);
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        helper(nums, new ArrayList<>(), 0);
        
        return result;
    }
    
    private static void helper(int[] nums, List<Integer> list, int index) {
        
        // terminator
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
    
        // process
        list.add(nums[index]);
        helper(nums, list, index + 1);
        
        // clear last path's state
        list.remove(list.size() - 1);

        while(index+1<nums.length && nums[index]==nums[index+1] )
            index++;
        
        // continue to drill down
        helper(nums, list, index + 1);
    }
}
