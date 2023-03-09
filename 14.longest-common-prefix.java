import java.util.Arrays;

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
        int n = strs[0].length(), i = 0;
        for (; i < n; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i) {
                    return strs[0].substring(0, i);
                }
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, i);
    }
}
// @lc code=end

