/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int m = gas.length;
        int[] gap = new int[m * 2];
        for (int i = 0; i < m; i++) {
            gap[i] = gas[i] - cost[i];
        }
        System.arraycopy(gap, 0, gap, m, m);
        int start = -1, amount = -1;
        for (int i = 0; i < gap.length; i++) {
            if (amount < 0) {
                start = i;
                amount = gap[i];
            } else {
                amount += gap[i];
            }
            if (amount >= 0 && i - start + 1 == m) {
                return start;
            }
        }

        return -1;
    }
}
// @lc code=end

