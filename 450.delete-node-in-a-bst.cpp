/*
 * @lc app=leetcode id=450 lang=cpp
 *
 * [450] Delete Node in a BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* deleteNode(TreeNode* root, int key) {
        TreeNode* parent = nullptr;
        TreeNode* current = root;

        while (current != nullptr) {
            if (current->val == key) {
                break;
            }
            parent = current;
            if (current->val > key) {
                current = current->left;
                continue;
            }
            if (current->val < key) {
                current = current->right;
            }
        }
        if (current == nullptr) {
            return root;
        }
        if (current->left != nullptr && current->right != nullptr) {
            TreeNode* tmp = current;
            parent = current;
            current = current->right;
            while (current->left != nullptr) {
                parent = current;
                current = current->left;
            }
            tmp->val = current->val;
        }
        if (parent == nullptr) {
            if (current->left == nullptr) {
                root = current->right;
            } else {
                root = current->left;
            }
        } else {
            TreeNode* tmp;
            if (current->left == nullptr) {
                tmp = current->right;
            } else {
                tmp = current->left;
            }
            if (parent->right == current) {
                parent->right = tmp;
            } else {
                parent->left = tmp;
            }
        }
        delete current;

        return root;
    }
};
// @lc code=end

