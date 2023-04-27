import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && (i == heights.length || (heights[i] < heights[stack.peek()]))) {
                int h = stack.pop();
                int area = heights[h] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                max = Math.max(max, area);
            }
            stack.push(i);
        }

        return max;
    }
}
// @lc code=end

