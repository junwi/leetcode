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
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1) return head;
		ListNode p = null, node = head, result = head;
		while (true) {
			int n = k;
			ListNode last = node;
			while (n-- > 0) {
				if (last == null) return result;
				last = last.next;
			}
			n = k;
			last = node;
			while (n-- > 1) {
				ListNode next = node.next;
				node.next = next.next;
				next.next = last;
				last = next;
			}
			if (p == null) {
				result = last;
			} else {
				p.next = last;
			}
			p = node;
			node = p.next;
		}
	}
}
