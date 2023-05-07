/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!solve(root.left, null, root)) {
            return false;
        }
        if (!solve(root.right, root, null)) {
            return false;
        }
        return true;
    }

    private boolean solve(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) {
            return true;
        }
        if (left != null && left.val >= root.val) {
            return false;
        }
        if (right != null && right.val <= root.val) {
            return false;
        }
        if (!solve(root.left, left, root)) {
            return false;
        }
        if (!solve(root.right, root, right)) {
            return false;
        }
        return true;
    }
}
// @lc code=end

