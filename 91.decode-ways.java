/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1, prepre = 1;
        for (int i = 1; i < s.length(); i++) {
            char first = s.charAt(i - 1);
            char second = s.charAt(i);
            int cur = 0;
            if (second >= '1' && second <= '9') {
                cur = pre;
            }
            if (first == '1' || (first == '2' && second <= '6')) {
                cur += prepre;
            }
            prepre = pre;
            pre = cur;
        }
        return pre;
    }
}
// @lc code=end

