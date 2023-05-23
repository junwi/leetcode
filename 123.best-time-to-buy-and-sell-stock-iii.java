/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, secondBuy = Integer.MIN_VALUE, firstSell = 0, secondSell = 0;
        for (int price : prices) {
            firstBuy = Integer.max(firstBuy, -price);
            firstSell = Integer.max(firstSell, firstBuy + price);
            secondBuy = Integer.max(secondBuy, firstSell - price);
            secondSell = Integer.max(secondSell, secondBuy + price);
        }

        return secondSell;
    }
}
// @lc code=end

