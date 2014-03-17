/**
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

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
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode result = null, current = null;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int v1 = l1 != null ? l1.val : 0;
			int v2 = l2 != null ? l2.val : 0;
			int n = v1 + v2 + carry;
			carry = n / 10;
			n = n % 10;
			ListNode node = new ListNode(n);
			if (result == null) result = node;
			else current.next = node;
			current = node;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		return result;
	}
}
