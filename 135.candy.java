/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int m = ratings.length;
        int[] candies = new int[m];
        Arrays.fill(candies, 1);
        for (int i = 1; i < m; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        int amount = 0;
        for (int i : candies) {
            amount += i;
        }

        return amount;
    }
}
// @lc code=end

