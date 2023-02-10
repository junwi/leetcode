/*
 * @lc app=leetcode id=2 lang=cpp
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode head;
        ListNode* cur = &head;
        int carry = 0;
        while (l1 || l2 || carry > 0) {
            carry += l1 ? l1->val : 0;
            carry += l2 ? l2->val : 0;
            cur->next = new ListNode(carry % 10);
            carry /= 10;
            cur = cur->next;
            l1 = l1 ? l1->next : NULL;
            l2 = l2 ? l2->next : NULL;
        }

        return head.next;
    }
};
// @lc code=end

