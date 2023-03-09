/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] dict = new int[256];
        int l = 0, r = 0, max = 0, n = s.length();
        while (r < n) {
            char c = s.charAt(r++);
            if (dict[c] > 0) {
                while (l < dict[c]) {
                    dict[s.charAt(l++)] = 0;
                }
            } else {
                max = Math.max(max, r - l);
            }
            dict[c] = r;
        }
        return max;
    }
}
// @lc code=end

