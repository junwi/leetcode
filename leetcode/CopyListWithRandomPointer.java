/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		RandomListNode node = head;
		while (node != null) {
			RandomListNode next = node.next;
			RandomListNode copy = new RandomListNode(node.label);
			copy.next = next;
			node.next = copy;
			node = next;
		}
		node = head;
		while (node != null) {
			RandomListNode copy = node.next;
			RandomListNode next = copy.next;
			if (node.random != null) {
				copy.random = node.random.next;
			}
			node = next;
		}
		node = head;
		RandomListNode copyHead = head.next;
		while (node != null) {
			RandomListNode copy = node.next;
			RandomListNode next = copy.next;
			node.next = next;
			node = next;
			if (next != null) {
				copy.next = next.next;
			}
		}
		return copyHead;
	}
}
