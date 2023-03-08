/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int num = 1, tar = n * n;
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] matrix = new int[n][n];
        while (num <= tar) {
            // left to right
            for (int i = l; i <= r; i++) {
                matrix[t][i] = num++;
            }
            t++;
            // top to bottom
            for (int i = t; i <= b; i++) {
                matrix[i][r] = num++;
            }
            r--;
            // right to left
            for (int i = r; i >= l; i--) {
                matrix[b][i] = num++;
            }
            b--;
            // bottom to top
            for (int i = b; i >= t; i--) {
                matrix[i][l] = num++;
            }
            l++;
        }

        return matrix;
    }
}
// @lc code=end

