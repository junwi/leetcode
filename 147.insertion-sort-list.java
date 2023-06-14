/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head, last = head, node = head.next;
        while (node != null) {
            ListNode next = node.next;
            if (node.val <= first.val) {
                node.next = first;
                first = node;
            } else if (node.val >= last.val) {
                last.next = node;
                last = node;
            } else {
                ListNode pre = first;
                while (pre.next.val < node.val) {
                    pre = pre.next;
                }
                ListNode tmp = pre.next;
                pre.next = node;
                node.next = tmp;
            }
            node = next;
        }
        last.next = null;

        return first;
    }
}
// @lc code=end

