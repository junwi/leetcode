import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        if (target < candidates[0]) {
            return result;
        }
        combinationSum(candidates, target, 0, new Stack<>(), result);

        return result;
    }

    private void combinationSum(int[] candidates, int target, int index, Stack<Integer> stack, List<List<Integer>> result) {
        for (int i = index; i < candidates.length; i++) {
            int n = candidates[i];
            if (n > target) {
                return;
            }
            if (n == target) {
                stack.push(n);
                result.add(new ArrayList<>(stack));
                stack.pop();
                return;
            }
            stack.push(n);
            combinationSum(candidates, target - n, i, stack, result);
            stack.pop();
        }
    }
}
// @lc code=end

