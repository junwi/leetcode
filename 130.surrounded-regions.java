/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, m, n);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1, m, n);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j, m, n);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j, m, n);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                    continue;
                }
                board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int x, int y, int m, int n) {
        board[x][y] = 'Y';
        for (int[] direction : directions) {
            int i = x + direction[0], j = y + direction[1];
            if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'O') {
                dfs(board, i, j, m, n);
            }
        }
    }
}
// @lc code=end

