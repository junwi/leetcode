/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int have = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int gap = prices[i] + have;
            if (gap > max) {
                max = gap;
            } else {
                have = Math.max(have, -prices[i]);
            }
        }

        return max;
    }
}
// @lc code=end

