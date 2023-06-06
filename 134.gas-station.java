/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int m = gas.length;
        int spare = 0;
        int minIndex = 0;
        int minSpare = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        if (spare < 0) {
            return -1;
        }
        if (minSpare >= 0) {
            return 0;
        }

        return (minIndex + 1) % m;
    }
}
// @lc code=end

