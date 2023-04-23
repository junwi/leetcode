/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        ListNode result = head.next;
        if (result == null) return head;
        head.next = result.next;
        result.next = head;
        while (node.next != null && node.next.next != null) {
            ListNode first = node.next;
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            node.next = second;
            node = first;
        }
        return result;
    }
}
