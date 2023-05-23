/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Integer.max(buy, -prices[i]);
            sell = Integer.max(sell, buy + prices[i]);
        }

        return sell;
    }
}
// @lc code=end

