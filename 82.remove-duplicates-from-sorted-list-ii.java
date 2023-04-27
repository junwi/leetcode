/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode hair = new ListNode();
        ListNode dup = null, pre = hair;
        hair.next = head;
        head = head.next;
        while (head != null) {
            if (dup != null) {
                if (dup.val == head.val) {
                    pre.next = head.next;
                } else {
                    dup = null;
                }
                head = head.next;
                continue;
            }
            if (head.val == pre.next.val) {
                dup = head;
                head = head.next;
                pre.next = head;
                continue;
            }
            pre = pre.next;
            head = head.next;
        }
        return hair.next;
    }
}
// @lc code=end

