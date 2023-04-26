/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int s = 0, c = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                c++;
            } else if (nums[i - 1] != nums[i]) {
                c = 0;
            }
            if (c <= 1) {
                nums[++s] = nums[i];
            }
        }

        return s + 1;
    }
}
// @lc code=end

