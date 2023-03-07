import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n + 1][n + 1];
        List<List<String>> result = new ArrayList<>();

        solve(board, result, 1);

        return result;
    }

    private void solve(boolean[][] board, List<List<String>> result, int count) {
        int n = board.length - 1;
        if (count == n + 1) {
            result.add(stringify(board));
            return;
        }
        for (int i = 1; i <= n; i++) {
            board[count][i] = true;
            if (validate(board, count, i)) {
                solve(board, result, count + 1);
            }
            board[count][i] = false;
        }
    }

    private boolean validate(boolean[][] board, int x, int y) {
        int n = board.length - 1;
        for (int i = 1; i < x; i++) {
            if (i < x && board[i][y]) return false;
        }
        for (int i = x - 1, j = y - 1; i > 0 && j > 0; i--, j--) {
            if (board[i][j]) return false;
        }
        for (int i = x - 1, j = y + 1; i > 0 && j <= n; i--, j++) {
            if (board[i][j]) return false;
        }

        return true;
    }

    private List<String> stringify(boolean[][] board) {
        List<String> result = new ArrayList<>();
        int n = board.length - 1;
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                sb.append(board[i][j] ? 'Q' : '.');
            }
            result.add(sb.toString());
        }

        return result;
    }
}
// @lc code=end

