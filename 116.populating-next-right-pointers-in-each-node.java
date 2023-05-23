/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> queue = new ArrayDeque<>();
        Node tag = new Node();
        queue.addLast(root);
        queue.addLast(tag);
        Node pre = null;
        while (queue.size() > 1) {
            Node node = queue.removeFirst();
            if (node == tag) {
                pre = null;
                queue.addLast(tag);
                continue;
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
            if (pre != null) {
                pre.next = node;
            }
            pre = node;
        }

        return root;
    }
}
// @lc code=end

