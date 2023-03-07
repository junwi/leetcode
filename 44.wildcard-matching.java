/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] mem = new boolean[m + 1][n + 1];
        mem[0][0] = true;
        for (int i = 1; i <= m; i++) {
            mem[i][0] = false;
        }
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                mem[0][j] = mem[0][j - 1];
            } else {
                mem[0][j] = false;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == '?') {
                    mem[i][j] = mem[i - 1][j - 1];
                } else if (pc == '*') {
                    mem[i][j] = mem[i - 1][j - 1] || mem[i][j - 1] || mem[i - 1][j];
                } else {
                    char sc = s.charAt(i - 1);
                    mem[i][j] = mem[i - 1][j - 1] && (pc == sc);
                }
            }
        }

        return mem[m][n];
    }
}
// @lc code=end

