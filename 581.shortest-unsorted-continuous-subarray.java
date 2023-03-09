/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < nums.length - 1 && nums[l] <= nums[l + 1]) ++l;
        if (l == nums.length - 1) return 0;
        while (r > 0 && nums[r - 1] <= nums[r]) --r;
        int min = nums[r], max = nums[l];
        for (int i = l; i <= r; ++i) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }

        while (l > 0 && nums[l - 1] > min) --l;
        while (r < nums.length - 1 && nums[r + 1] < max) ++r;

        return r - l + 1;
    }
}
// @lc code=end

