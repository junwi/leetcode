import java.util.BitSet;

/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    private BitSet col = new BitSet();
    private BitSet main = new BitSet();
    private BitSet sub = new BitSet();
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
            if (col.get(y) || main.get(x - y + n) || sub.get(x + y)) {
                continue;
            }
            col.set(y);
            main.set(x - y + n);
            sub.set(x + y);
            solve(x + 1);
            col.clear(y);
            main.clear(x - y + n);
            sub.clear(x + y);
        }
    }
}
// @lc code=end

