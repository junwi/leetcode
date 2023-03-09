/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return sb.toString();
        }
        int n = strs[0].length();
        for (int i = 0; i < n; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i) {
                    c = 0;
                    break;
                }
                if (strs[j].charAt(i) != c) {
                    c = 0;
                    break;
                }
            }
            if (c != strs[0].charAt(i)) {
                return sb.toString();
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
// @lc code=end

