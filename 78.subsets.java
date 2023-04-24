import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        solve(0, nums, stack, result);

        return result;
    }

    private void solve(int index, int[] nums, Stack<Integer> stack, List<List<Integer>> result) {
        result.add(new ArrayList<>(stack));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            stack.push(nums[i]);
            solve(i + 1, nums, stack, result);
            stack.pop();
        }
    }
}
// @lc code=end

