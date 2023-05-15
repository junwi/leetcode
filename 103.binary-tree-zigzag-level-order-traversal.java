import java.util.Deque;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    private TreeNode tag = new TreeNode();
    private Deque<TreeNode> queue = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private boolean left = true;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        queue.addLast(root);
        queue.addLast(tag);
        while (queue.size() > 1) {
            if (left) {
                solveLeft();
            } else {
                solveRight();
            }
        }
        if (!list.isEmpty()) {
            result.add(list);
        }

        return result;
    }

    private void solveLeft() {
        TreeNode node = queue.getFirst();
        if (node == tag) {
            result.add(list);
            list = new ArrayList<>();
            left = false;
            return;
        }
        queue.removeFirst();
        list.add(node.val);
        if (node.left != null) {
            queue.addLast(node.left);
        }
        if (node.right != null) {
            queue.addLast(node.right);
        }
    }

    private void solveRight() {
        TreeNode node = queue.getLast();
        if (node == tag) {
            result.add(list);
            list = new ArrayList<>();
            left = true;
            return;
        }
        queue.removeLast();
        list.add(node.val);
        if (node.right != null) {
            queue.addFirst(node.right);
        }
        if (node.left != null) {
            queue.addFirst(node.left);
        }
    }
}
// @lc code=end

