/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return solve(nums, 0, nums.length - 1);
    }

    private TreeNode solve(int[] nums, int start, int end) {
        int m = (start + end) / 2;
        TreeNode node = new TreeNode(nums[m]);
        if (m > start) {
            node.left = solve(nums, start, m - 1);
        }
        if (m < end) {
            node.right = solve(nums, m + 1, end);
        }

        return node;
    }
}
// @lc code=end

