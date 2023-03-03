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
	hair := &ListNode{Next: head}
	prev := hair
	for true {
		last := prev
		for i := 0; i < k; i++ {
			last = last.Next
			if last == nil {
				return hair.Next
			}
		}
		next := last.Next
		first := prev.Next
		reverse(first, last)
		first.Next = next
		prev.Next = last
		prev = first
	}

	return hair.Next
}

func reverse(first, last *ListNode) {
	var prev *ListNode = nil
	node := first
	for prev != last {
		next := node.Next
		node.Next = prev
		prev = node
		node = next
	}
}

// @lc code=end

