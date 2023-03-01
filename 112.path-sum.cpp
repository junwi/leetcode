/*
 * @lc app=leetcode id=112 lang=cpp
 *
 * [112] Path Sum
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
    bool leafSum(TreeNode* root, int sum, int targetSum) {
        if (root == nullptr) {
            return sum == targetSum;
        }
        sum += root->val;
        if (root->left == nullptr && root->right == nullptr) {
            return sum == targetSum;
        }
        if (root->left == nullptr) {
            return leafSum(root->right, sum, targetSum);
        }
        if (root->right == nullptr) {
            return leafSum(root->left, sum, targetSum);
        }
        return leafSum(root->right, sum, targetSum) || leafSum(root->left, sum, targetSum);
    }
public:
    bool hasPathSum(TreeNode* root, int targetSum) {
        if (root == nullptr) {
            return false;
        }
        return leafSum(root, 0, targetSum);
    }
};
// @lc code=end

