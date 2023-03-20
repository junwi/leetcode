/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        if (head == null) return head;
        ListNode hair = new ListNode();
        ListNode pre = hair, foot = head;
        while (head != null) {
            int n = k;
            for (; n > 1 && foot.next != null; n--) {
                foot = foot.next;
            }
            if (n > 1) break;
            ListNode next = foot.next;
            reverse(head, foot);
            pre.next = foot;
            pre = head;
            head = next;
            foot = next;
        }
        pre.next = head;

        return hair.next;
    }

    private void reverse(ListNode first, ListNode last) {
        ListNode next = first.next;
        while (first != last) {
            ListNode nnext = next.next;
            next.next = first;
            first = next;
            next = nnext;
        }
    }
}
// @lc code=end

