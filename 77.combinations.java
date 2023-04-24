import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        solve(1, n, k, stack, result);

        return result;
    }

    private void solve(int start, int end, int k, Stack<Integer> stack, List<List<Integer>> result) {
        if (stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }
        if (start > end) {
            return;
        }
        for (int i = start; i <= end - (k - stack.size()) + 1; i++) {
            stack.push(i);
            solve(i + 1, end, k, stack, result);
            stack.pop();
        }
    }
}
// @lc code=end

