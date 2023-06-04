/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] mem = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int l = 0; l <= r; l++) {
                mem[l][r] = (chars[l] == chars[r]) && (r - l <= 2 || mem[l + 1][r - 1]);
            }
        }

        solve(s, 0, mem, new ArrayList<>(), result);

        return result;
    }

    private void solve(String s, int l, boolean[][] mem, List<String> list, List<List<String>> result) {
        if (l == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int r = l; r < s.length(); r++) {
            if (mem[l][r]) {
                list.add(s.substring(l, r + 1));
                solve(s, r + 1, mem, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
// @lc code=end

