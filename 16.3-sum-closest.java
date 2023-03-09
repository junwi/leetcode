/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int min = result - target;
        min = min < 0 ? -min : min;
        for (int i = 0; i < nums.length - 2; ++i) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                int m = sum - target;
                m = m < 0 ? -m : m;
                if (m < min) {
                    min = m;
                    result = sum;
                }
                if (sum > target) {
                    --k;
                } else {
                    ++j;
                }
            }
        }

        return result;
    }
}
// @lc code=end

