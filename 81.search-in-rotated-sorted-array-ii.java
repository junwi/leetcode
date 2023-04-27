/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (nums[m] == target) {
                return true;
            }
            if (nums[s] == nums[m] && nums[m] == nums[e]) {
                s++;
                e--;
            } else if (nums[s] <= nums[m]) {
                if (nums[m] > target && target >= nums[s]) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } else {
                if (nums[m] < target && target <= nums[e]) {
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }

        return false;
    }
}
// @lc code=end

