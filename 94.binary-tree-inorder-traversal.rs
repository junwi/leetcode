/*
 * @lc app=leetcode id=94 lang=rust
 *
 * [94] Binary Tree Inorder Traversal
 */

// @lc code=start
// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
// 
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }
use std::rc::Rc;
use std::cell::RefCell;
impl Solution {
    pub fn inorder_traversal(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let mut v: Vec<i32> = Vec::new();
        let mut st: Vec<Rc<RefCell<TreeNode>>> = Vec::new();
        let mut current = root;
        while let Some(mut node) = current {
            while node.borrow().left.is_some() {
                st.push(node.clone());
                let o = node.borrow().left.clone();
                node = o.unwrap();
            }
            while node.borrow().right.is_none() && !st.is_empty() {
                v.push(node.borrow().val);
                node = st.pop().unwrap();
            }
            v.push(node.borrow().val);
            current = node.borrow().right.clone();
        }
        
        return v;
    }
}
// @lc code=end

