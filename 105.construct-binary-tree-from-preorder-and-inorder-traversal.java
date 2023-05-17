/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        int val = preorder[ps];
        TreeNode node = new TreeNode(val);
        if (ps == pe) {
            return node;
        }
        int im = is;
        while (im <= ie) {
            if (inorder[im] == val) {
                break;
            }
            im++;
        }
        if (im > is) {
            TreeNode left = build(preorder, ps + 1, ps + (im - is), inorder, is, im - 1);
            node.left = left;
        }
        if (im < ie) {
            TreeNode right = build(preorder, ps + (im - is) + 1, pe, inorder, im + 1, ie);
            node.right = right;
        }

        return node;
    }
}
// @lc code=end

