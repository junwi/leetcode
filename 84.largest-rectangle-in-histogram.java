import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int m = heights.length, index = 0;
        int[] stack = new int[m];
        int max = 0;
        for (int i = 0; i <= m; i++) {
            if (index == 0) {
                stack[index++] = i;
                continue;
            }
            while (index > 0 && (i == m || heights[i] < heights[stack[index - 1]])) {
                int h = heights[stack[--index]];
                int w = index == 0 ? i : i - stack[index - 1] - 1;
                int area = w * h;
                if (area > max) {
                    max = area;
                }
            }
            stack[index++] = i;
        }

        return max;
    }
}
// @lc code=end

