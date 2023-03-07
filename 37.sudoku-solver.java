/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
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

    private void fill(int x, int y, int n, boolean flag) {
        rows[x][n] = flag;
        cols[y][n] = flag;
        cells[x / 3][y / 3][n] = flag;
    }

    private boolean[] getPossible(int x, int y, char[][] board) {
        boolean[] possible = new boolean[9];
        for (int i = 0; i < possible.length; i++) {
            possible[i] = !(rows[x][i] || cols[y][i] || cells[x / 3][y / 3][i]);
        }

        return possible;
    }

    private int[] next(char[][] board) {
        int min = 0;
        int x = -1;
        int y = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    boolean[] possible = getPossible(i, j, board);
                    int len = len(possible);
                    if (min == 0 || len < min) {
                        min = len;
                        x = i;
                        y = j;
                    }
                }

            }
        }

        return new int[] {x, y};
    } 

    private int len(boolean[] possible) {
        int len = 0;
        for (boolean b : possible) {
            len += b ? 1 : 0;
        }

        return len;
    }

    private boolean solve(char[][] board, int count) {
        if (count == 0) {
            return true;
        }
        int[] pos = next(board);
        if (pos[0] == -1) {
            return false;
        }
        boolean[] possible = getPossible(pos[0], pos[1], board);
        for (int i = 0; i < possible.length; i++) {
            if (!possible[i]) {
                continue;
            }
            fill(pos[0], pos[1], i, true);
            board[pos[0]][pos[1]] = (char) ('1' + i);
            if (solve(board, count - 1)) {
                return true;
            }
            fill(pos[0], pos[1], i, false);
            board[pos[0]][pos[1]] = '.';
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    count++;
                    continue;
                }
                int n = board[i][j] - '1';
                rows[i][n] = true;
                cols[j][n] = true;
                cells[i / 3][j / 3][n] = true;
            }
        }
        solve(board, count);
    }
}
// @lc code=end

