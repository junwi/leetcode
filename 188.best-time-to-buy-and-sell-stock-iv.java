/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k + 1], sell = new int[k + 1];
        for (int i = 0; i < buy.length; i++) {
            buy[i] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            for (int i = 1; i < buy.length; i++) {
                buy[i] = Integer.max(buy[i], sell[i - 1] - price);
                sell[i] = Integer.max(sell[i], buy[i]  + price);
            }
        }

        return sell[k];
    }
}
// @lc code=end

