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
        int flag = 0;
        while (l1 != NULL && l2 != NULL) {
            int a = l1->val;
            int b = l2->val;
            l1 = l1->next;
            l2 = l2->next;
            int r = a + b + flag;
            if (r >= 10) {
                flag = 1;
                r -= 10;
            } else {
                flag = 0;
            }
            cur->next = new ListNode(r);
            cur = cur->next;
        }
        ListNode* l = NULL;
        if (l1 != NULL) {
            l = l1;
        } else {
            l = l2;
        }
        while (l != NULL) {
            int r = l->val + flag;
            if (r >= 10) {
                flag = 1;
                r -= 10;
            } else {
                flag = 0;
            }
            cur->next = new ListNode(r);
            cur = cur->next;
        }

        return head.next;
    }
};
// @lc code=end

