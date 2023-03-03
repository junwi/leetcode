/*
 * @lc app=leetcode id=25 lang=golang
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseKGroup(head *ListNode, k int) *ListNode {
	if head == nil || k <= 1 {
		return head
	}
	preHead := new(ListNode)
	preHead.Next = head
	prev := preHead
	for true {
		last := prev
		n := 0
		for n < k {
			n += 1
			last = last.Next
			if last == nil {
				return preHead.Next
			}
		}
		n = 0
		last = prev.Next
		for n < k-1 {
			n += 1
			first := prev.Next
			prev.Next = last.Next
			last.Next = last.Next.Next
			prev.Next.Next = first

			n := preHead.Next
			for n != nil {
				n = n.Next
			}
		}
		prev = last
	}

	return preHead.Next
}

// @lc code=end

