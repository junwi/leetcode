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
        for (int i = 0; i < m; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = i + 1; j <= m; j++) {
                String sub = s.substring(i, j);
                if (set.contains(sub)) {
                    dp[j] = true;
                }
            }
        }

        return dp[m];
    }
}
// @lc code=end

