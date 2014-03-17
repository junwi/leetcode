/**
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
  Return 6.

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public int maxPathSum(TreeNode root) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		if (root == null) return 0;
		int[] result = maxPathSum1(root);
		return result[0];
	}

	private int[] maxPathSum1(TreeNode node) {
		if (node == null) return new int[] {Integer.MIN_VALUE, 0};
		int[] left = maxPathSum1(node.left);
		int[] right = maxPathSum1(node.right);
		int sum = node.val;
		if (left[1] > 0) sum += left[1];
		if (right[1] > 0) sum += right[1];
		int path = Math.max(left[1], right[1]);
		path = path > 0 ? path + node.val : node.val;
		sum = Math.max(sum, Math.max(left[0], right[0]));
		return new int[] {sum, path};
	}
}
