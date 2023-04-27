/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    private int[][] directions = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    if (solve(board, used, i, j, word, 1)) {
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean solve(char[][] board, boolean[][] used, int i, int j, String word, int pos) {
        if (pos == word.length()) {
            return true;
        }
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x < 0 || y < 0 || x >= m || y >= n || used[x][y]) {
                continue;
            }
            if (board[x][y] == word.charAt(pos)) {
                used[x][y] = true;
                if (solve(board, used, x, y, word, pos + 1)) {
                    return true;
                }
                used[x][y] = false;
            }
        }

        return false;
    }
}
// @lc code=end

