import java.util.Stack;

/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int start = -1, m = s.length();
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    int left = stack.isEmpty() ? start : stack.peek();
                    max = Math.max(max, i - left);
                }
            }
        }

        return max;
    }
}
// @lc code=end

