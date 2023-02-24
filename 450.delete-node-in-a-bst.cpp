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
            delete current;
        } else if (current->left == nullptr && current->right == nullptr) {
            if (parent->left == current) {
                parent->left = nullptr;
            } else {
                parent->right = nullptr;
            }
            delete current;
            return root;
        } else if (current->left == nullptr) {
            if (parent->left == current) {
                parent->left = current->right;
            } else {
                parent->right = current->right;
            }
            delete current;
        } else if (current->right == nullptr) {
            if (parent->left == current) {
                parent->left = current->left;
            } else {
                parent->right = current->left;
            }
            delete current;
        }

        return root;
    }
};
// @lc code=end

