/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 */

// @lc code=start
class Solution {
    public boolean isScramble(String s1, String s2) {
        int m = s1.length();
        boolean[][][] dp = new boolean[m][m][m + 1];
        for (int len = 1; len <= m; len++) {
            for (int i = 0; i <= m - len; i++) {
                for (int j = 0; j <= m - len; j++) {
                    if (len == 1) {
                        dp[i][j][len] = (s1.charAt(i) == s2.charAt(j));
                        continue;
                    }
                    for (int t = 1; t < len; t++) {
                        dp[i][j][len] = (dp[i][j][t] && dp[i + t][j + t][len - t])
                            || (dp[i][j + len - t][t] && dp[i + t][j][len - t]);
                        if (dp[i][j][len]) {
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0][m];
    }
}
// @lc code=end

