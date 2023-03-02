/*
 * @lc app=leetcode id=94 lang=cpp
 *
 * [94] Binary Tree Inorder Traversal
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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> vec;
        stack<TreeNode*> st;
        TreeNode* node = root;
        while (node != nullptr) {
            while (node->left != nullptr) {
                st.push(node);
                node = node->left;
            }
            while (node->right == nullptr && !st.empty()) {
                vec.push_back(node->val);
                node = st.top();
                st.pop();
            }
            vec.push_back(node->val);
            node = node->right;
        }

        return vec;
    }
};
// @lc code=end

