/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        for (int step = 1; step < len; step *= 2) {
            ListNode pre = hair;
            curr = pre.next;
            while (curr != null) {
                ListNode left = curr;
                ListNode right = cut(curr, step);
                curr = cut(right, step);
                pre.next = merge(left, right);
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }

        return hair.next;
    }

    private ListNode cut(ListNode head, int step) {
        while (head != null && step > 1) {
            head = head.next;
            step--;
        }
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        head.next = null;

        return next;
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode node = new ListNode();
        ListNode pre = node;
        while (first != null && second != null) {
            if (first.val < second.val) {
                pre.next = first;
                first = first.next;
            } else {
                pre.next = second;
                second = second.next;
            }
            pre = pre.next;
        }
        if (first != null) {
            pre.next = first;
        } else {
            pre.next = second;
        }

        return node.next;
    }
}
// @lc code=end

