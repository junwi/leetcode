/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int m = 0;
        char last = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == last) {
                m++;
            } else if (m == 0) {
                m++;
                last = c;
            } else {
                sb.append(m);
                sb.append(last);
                m = 1;
                last = c;
            }
        }
        if (m > 0) {
            sb.append(m);
            sb.append(last);
        }

        return sb.toString();
    }
}
// @lc code=end

