import java.util.BitSet;

/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    private int col = 0;
    private int main = 0;
    private int sub = 0;
    private int n;
    private int result = 0;

    public int totalNQueens(int n) {
        this.n = n;

        solve(0);

        return result;
    }

    private void solve(int x) {
        if (x == n) {
            ++result;
            return;
        }
        for (int y = 0; y < n; y++) {
            if (get(col, y) || get(main, x - y + n) || get(sub, x + y)) {
                continue;
            }
            col = set(col, y);
            main = set(main, x - y + n);
            sub = set(sub, x + y);
            solve(x + 1);
            col = clear(col, y);
            main = clear(main, x - y + n);
            sub = clear(sub, x + y);
        }
    }

    private int set(int source, int bitIndex) {
        return source | (1 << bitIndex);
    }

    private int clear(int source, int bitIndex) {
        return source & ~(1 << bitIndex);
    }

    private boolean get(int source, int bitIndex) {
        return (source & (1 << bitIndex)) != 0;
    }
}
// @lc code=end

