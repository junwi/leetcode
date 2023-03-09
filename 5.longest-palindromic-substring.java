/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int max = 0, l = 0, r = 0, n = s.length();
        for (int i = 0; i < s.length(); i++) {
            int a = i, b = i;
            while (a >= 0 && b < n && s.charAt(a) == s.charAt(b)) {
                --a;
                ++b;
            }
            if (b - a > max) {
                max = b - a;
                l = a + 1;
                r = b - 1;
            }
            a = i;
            b = i + 1;
            while (a >= 0 && b < n && s.charAt(a) == s.charAt(b)) {
                --a;
                ++b;
            }
            if (b - a > max) {
                max = b - a;
                l = a + 1;
                r = b - 1;
            }
        }
        return s.substring(l, r + 1);
    }
}
// @lc code=end

