/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node node = head;
        while (node != null) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
        node = head;
        while (node != null) {
            Node copy = node.next;
            if (node.random != null) {
                copy.random = node.random.next;
            }
            node = copy.next;
        }
        node = head;
        Node result = new Node(0);
        Node pre = result;
        while (node != null) {
            Node copy = node.next;
            node.next = copy.next;
            pre.next = copy;
            node = node.next;
            pre = copy;
        }

        return result.next;
    }
}
// @lc code=end

