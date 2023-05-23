/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int sell = prices[i] + buy;
            if (sell > 0) {
                result += sell;
            }
            buy = -prices[i];
        }

        return result;
    }
}
// @lc code=end

