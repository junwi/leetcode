import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        solve(0, nums, list, result);

        return result;
    }

    private void solve(int index, int[] nums, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            solve(i + 1, nums, list, result);
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

