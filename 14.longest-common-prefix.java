/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        int n = str.length();
        for (int j = 1; j < strs.length; j++) {
            String s = strs[j];
            n = Math.min(n, s.length());
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) != s.charAt(i)) {
                    n = i;
                    break;
                }
            }
        }

        return str.substring(0, n);
    }
}
// @lc code=end

