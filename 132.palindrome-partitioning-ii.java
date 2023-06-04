/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] mem = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int l = 0; l <= r; l++) {
                mem[l][r] = (chars[l] == chars[r]) && (r - l <= 2 || mem[l + 1][r - 1]);
            }
        }
        int[] f = new int[n];
        for (int j = 0; j < n; j++) {
            if (mem[0][j]) {
                f[j] = 0;
                continue;
            }
            f[j] = n;
            for (int i = 0; i <= j; i++) {
                if (mem[i][j]) {
                    f[j] = Integer.min(f[j], f[i - 1] + 1);
                }
            }
        }

        return f[n - 1];
    }
}
// @lc code=end

