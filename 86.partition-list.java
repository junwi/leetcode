/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(), last = new ListNode();
        ListNode less = first, more = last;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = head;
            } else {
                more.next = head;
                more = head;
            }
            head = head.next;
        }
        less.next = last.next;
        more.next = null;
        return first.next;
    }
}
// @lc code=end

