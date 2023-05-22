/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] mem = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            mem[i][0] = 1;
        }
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sc[i] == tc[j]) {
                    mem[i + 1][j + 1] = mem[i][j] + mem[i][j + 1];
                } else {
                    mem[i + 1][j + 1] = mem[i][j + 1];
                }
            }
        }

        return mem[m][n];
    }
}
// @lc code=end

