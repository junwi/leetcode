/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int have = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int gap = prices[i] + have;
            if (gap > 0) {
                result += gap;
            }
            have = -prices[i];
        }

        return result;
    }
}
// @lc code=end

