/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        fillAround(matrix, 1, 0, 0, n);

        return matrix;
    }

    private void fillAround(int[][] matrix, int begin, int x, int y, int n) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            matrix[x][y] = begin;
            return;
        }
        for (int i = 0; i < n; i++) {
            matrix[x][y + i] = begin++;
        }
        for (int i = 1; i < n; i++) {
            matrix[x + i][y + n - 1] = begin++;
        }
        for (int i = n - 2; i >= 0; i--) {
            matrix[x + n - 1][y + i] = begin++;
        }
        for (int i = n - 2; i >= 1; i--) {
            matrix[x + i][y] = begin++;
        }
        fillAround(matrix, begin, x + 1, y + 1, n - 2);
    }
}
// @lc code=end

