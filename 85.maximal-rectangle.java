/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    private int[] heights;
    private int[] stack;
    private int index;
    private int m;
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        m = matrix[0].length;
        heights = new int[m];
        stack = new int[m];
        int n = matrix.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            index = 0;
            int area = maxArea();
            if (area > max) {
                max = area;
            }
        }

        return max;
    }

    private int maxArea() {
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

