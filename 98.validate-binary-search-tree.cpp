/*
 * @lc app=leetcode id=98 lang=cpp
 *
 * [98] Validate Binary Search Tree
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
private:
    bool isValidBST(TreeNode* root, TreeNode* left, TreeNode* right) {
        if (root == nullptr) {
            return true;
        }
        if (left != nullptr && left->val >= root->val) {
            return false;
        }
        if (right != nullptr && right->val <= root->val) {
            return false;
        }
        return isValidBST(root->left, left, root) && isValidBST(root->right, root, right);
    }
public:
    bool isValidBST(TreeNode* root) {
        return isValidBST(root, nullptr, nullptr);
    }
};
// @lc code=end

