/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0, r = -1, n = nums.length;
        int min = nums[n - 1], max = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                r = i;
            } else {
                max = nums[i];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > min) {
                l = i;
            } else {
                min = nums[i];
            }
        }

        return r - l + 1;
    }
}
// @lc code=end

