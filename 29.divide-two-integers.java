/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        int flag = 1;
        if (dividend > 0) {
            dividend = -dividend;
            flag *= -1;
        }
        if (divisor > 0) {
            divisor = -divisor;
            flag *= -1;
        }
        int result = 0;
        while (dividend <= divisor) {
            int sum = divisor;
            int cnt = 1;
            while ((sum << 1) >= dividend && (sum << 1) < 0) {
                sum <<= 1;
                cnt <<= 1;
            }
            result += cnt;
            dividend -= sum;
        }

        if (result < 0 && flag == 1) {
            return -1 << 1 >>> 1;
        }

        return flag * result;
    }
}
// @lc code=end

