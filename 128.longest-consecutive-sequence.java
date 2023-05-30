/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (map.containsKey(n)) {
                continue;
            }
            int left = map.getOrDefault(n - 1, n);
            int right = map.getOrDefault(n + 1, n);
            map.put(n, n);
            map.put(left, right);
            map.put(right, left);
            int len = right - left + 1;
            if (max < len) {
                max = len;
            }
        }

        return max;
    }
}
// @lc code=end

