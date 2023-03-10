/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head, end = head, prev = null;
        while (n-- > 0 && end != null) {
            end = end.next;
        }
        while (end != null) {
            prev = start;
            start = start.next;
            end = end.next;
        }

        if (prev == null) {
            return start.next;
        }

        prev.next = start.next;

        return head;
    }
}
// @lc code=end

