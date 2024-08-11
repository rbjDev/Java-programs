package RecursionPractice;

import java.util.ArrayList;
import java.util.List;

public class GetPermutations {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs = new ArrayList();
        backtrack(rs, new ArrayList(), nums);
        return rs;
    }

    void backtrack(List<List<Integer>> rs, List<Integer> temp, int nums[]) {
        if (temp.size() == nums.length) {
            rs.add(new ArrayList(temp));
            return;
        }

        for (int n : nums) {
            if (temp.contains(n)) {
                continue;
            }
            temp.add(n);
            backtrack(rs, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
