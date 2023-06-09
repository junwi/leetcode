/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int m = s.length();
        boolean[][] dp = new boolean[m + 1][m+1];
        boolean[] mem = new boolean[m + 1];
        mem[0] = true;
        for (int i = 0; i < m; i++) {
            if (!mem[i]) {
                continue;
            }
            for (int j = i + 1; j <= m; j++) {
                String sub = s.substring(i, j);
                if (set.contains(sub)) {
                    dp[i][j] = true;
                    mem[j] = true;
                }
            }
        }
        List<String> result = new ArrayList<>(), list = new ArrayList<>();
        solve(s, dp, 0, result, list);

        return result;
    }

    private void solve(String s, boolean[][] dp, int i, List<String> result, List<String> list) {
        if (i == s.length()) {
            result.add(String.join(" ", list));
            return;
        }
        for (int j = i + 1; j <= s.length(); j++) {
            if (dp[i][j]) {
                String sub = s.substring(i, j);
                list.add(sub);
                solve(s, dp, j, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
// @lc code=end

