/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        int i = 0, j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i++) != sb.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

