#
# @lc app=leetcode id=21 lang=python3
#
# [21] Merge Two Sorted Lists
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 is None:
            return list2
        if list2 is None:
            return list1
        hair = ListNode()
        current = hair
        while list1 is not None and list2 is not None:
            if list1.val < list2.val:
                next = list1
                list1 = list1.next
            else:
                next = list2
                list2 = list2.next
            current.next = next
            current = next
        if list1 is not None:
            current.next = list1
        else:
            current.next = list2
        
        return hair.next
        
# @lc code=end

