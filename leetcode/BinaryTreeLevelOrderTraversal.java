/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
  3
 / \
9  20
  /  \
 15   7
return its level order traversal as:
[
 [3],
 [9,20],
 [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
  1
 / \
2   3
   /
  4
   \
    5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
*/
import java.util.LinkedList;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) return result;
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		while (!list.isEmpty()) {
			int len = list.size();
			ArrayList<Integer> level = new ArrayList<Integer>();
			result.add(level);
			for (int i = 0; i < len; ++i) {
				TreeNode node = list.poll();
				level.add(node.val);
				if (node.left != null) list.add(node.left);
				if (node.right != null) list.add(node.right);
			}
		}
		return result;
	}
}
