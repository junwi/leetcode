/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] status = new int[prices.length][3];
        status[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            status[i][0] = Integer.max(status[i - 1][0], status[i - 1][2]);
            status[i][1] = Integer.max(status[i - 1][1], status[i - 1][0] - prices[i]);
            status[i][2] = status[i - 1][1] + prices[i];
        }

        return Integer.max(status[n - 1][0], status[n - 1][2]);
    }
}
// @lc code=end

