/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int m = s.length();
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int r = 1; r <= m; r++) {
            for (int l = 0; l < m; l++) {
                if (!dp[l]) {
                    continue;
                }
                String sub = s.substring(l, r);
                if (set.contains(sub)) {
                    dp[r] = true;
                    break;
                }
            }
        }

        return dp[m];
    }
}
// @lc code=end

