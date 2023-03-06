/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][][] cells = new boolean[3][3][9];

    private boolean test(boolean[] room, int n) {
        return !room[n];
    }

    private boolean test(int x, int y, int n) {
        return test(rows[x], n) && test(cols[y], n) && test(cells[x / 3][y / 3], n);
    }

    public boolean isValidSudoku(char[][] board) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == '.') continue;
                int n = board[x][y] - '0' - 1;
                if (!test(x, y, n)) return false;
                rows[x][n] = true;
                cols[y][n] = true;
                cells[x / 3][y / 3][n] = true;
            }
        }

        return true;
    }
}
// @lc code=end

