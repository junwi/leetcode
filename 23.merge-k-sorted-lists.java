/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        int r = lists.length - 1;
        ListNode head = new ListNode();
        while (r > 0) {
            for (int l = 0; l < r; l++, r--) {
                if (lists[r] == null) {
                    continue;
                };
                if (lists[l] == null) {
                    lists[l] = lists[r];
                    continue;
                }
                ListNode node = head, list1 = lists[l], list2 = lists[r];
                
                while (list1 != null && list2 != null) {
                    ListNode current;
                    if (list1.val < list2.val) {
                        current = list1;
                        list1 = list1.next;
                    } else {
                        current = list2;
                        list2 = list2.next;
                    }
                    node.next = current;
                    node = current;
                }
                if (list1 != null) {
                    node.next = list1;
                } else {
                    node.next = list2;
                }
                lists[l] = head.next;
            }
        }

        return lists[0];
    }
}
// @lc code=end

