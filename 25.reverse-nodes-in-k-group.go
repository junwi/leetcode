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
	end := preHead
	n := 0
	for end != nil {
		if n < k {
			n += 1
			end = end.Next
			continue
		}
		next := end.Next

		ahead := prev
		current := prev.Next
		for ahead != end {
			tmp := current.Next
			current.Next = ahead
			ahead = current
			current = tmp
		}

		tmp := prev.Next
		tmp.Next = next
		prev.Next = end
		prev = tmp
		end = tmp
		n = 0
	}

	return preHead.Next
}

// @lc code=end

