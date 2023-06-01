/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    public int sumNumbers(TreeNode root) {
        return sum(root, 0, 0);
    }

    private int sum(TreeNode root, int n, int total) {
        n = n * 10 + root.val;
        if (root.left == null && root.right == null) {
            return total + n;
        }
        if (root.left != null) {
            total = sum(root.left, n, total);
        }
        if (root.right != null) {
            total = sum(root.right, n, total);
        }

        return total;
    }
}
// @lc code=end

