/**
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public boolean isBalanced(TreeNode root) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		int[] balance = balanceDepth(root);
		return balance[0] == 1;
	}

	private int[] balanceDepth(TreeNode node) {
		if (node == null) return new int[] {1, 0};
		int[] left = balanceDepth(node.left);
		if (left[0] == 0) return new int[] {0, 0};
		int[] right = balanceDepth(node.right);
		if (right[0] == 0) return new int[] {0, 0};
		int leftDepth = left[1] + 1;
		int rightDepth = right[1] + 1;
		if (leftDepth > rightDepth + 1 || rightDepth > leftDepth + 1) return new int[] {0,0};
		if (leftDepth > rightDepth) return new int[] {1, leftDepth};
		return new int[] {1, rightDepth};
	}
}
