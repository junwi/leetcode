import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    private boolean[] col;
    private boolean[] main;
    private boolean[] sub;
    private int[] path;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        col = new boolean[n];
        main = new boolean[2 * n];
        sub = new boolean[2 * n];
        path = new int[n];

        solve(result, 0, n);

        return result;
    }

    private void solve(List<List<String>> result, int x, int n) {
        if (x == n) {
            result.add(stringify());
            return;
        }
        for (int y = 0; y < n; y++) {
            if (col[y] || main[x - y + n] || sub[x + y]) {
                continue;
            }
            col[y] = true;
            main[x - y + n] = true;
            sub[x + y] = true;
            path[x] = y;
            solve(result, x + 1, n);
            col[y] = false;
            main[x - y + n] = false;
            sub[x + y] = false;
        }
    }

    private List<String> stringify() {
        List<String> result = new ArrayList<>();
        int n = path.length;
        for (int i : path) {
            StringBuilder sb = new StringBuilder();
            sb.append(".".repeat(n));
            sb.replace(i, i + 1, "Q");

            result.add(sb.toString());
        }

        return result;
    }
}
// @lc code=end

