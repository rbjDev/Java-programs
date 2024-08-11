package RecursionPractice;

import java.util.ArrayList;
import java.util.List;

public class ArraySubsets {
    public static void main(String[] args) {
       int nums[] = {1,2,2};
       System.out.println(subsets(nums));
       List<Integer> up = new ArrayList<>(); 
       for(int i:nums)
        up.add(i);
       System.out.println(getSubsets(new ArrayList<Integer>(), up));
    }
    static List<List<Integer>> result = new ArrayList<>();
    
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
        
        // continue to drill down
        helper(nums, list, index + 1);
    }

    private static List<List<Integer>> getSubsets(List<Integer> p, List<Integer> up){
        List<List<Integer>> list = new ArrayList<>();
        if( up==null || up.isEmpty()){
                list.add(new ArrayList<>(p));
            return list;
        }
        p.add(up.get(0));
        list.addAll(getSubsets(p, up.subList(1, up.size())));
        p.remove(p.size()-1);
        list.addAll(getSubsets(p, up.subList(1, up.size())));
        return list;
    }

    private static List<List<Integer>> getSubsetsWoDup(List<Integer> p, List<Integer> up){
        List<List<Integer>> list = new ArrayList<>();
        if( up==null || up.isEmpty()){
                list.add(new ArrayList<>(p));
            return list;
        }
        p.add(up.get(0));
        list.addAll(getSubsets(p, up.subList(1, up.size())));
        p.remove(p.size()-1);
        while()
        list.addAll(getSubsets(p, up.subList(1, up.size())));
        return list;
    }
}
