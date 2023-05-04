/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (m >= 0 || n >= 0) {
            int v;
            if (m < 0) {
                v = nums2[n--];
            } else if (n < 0) {
                v = nums1[m--];
            } else if (nums1[m] < nums2[n]) {
                v = nums2[n--];
            } else {
                v = nums1[m--];
            }
            nums1[i--] = v;
        }
    }
}
// @lc code=end

