/*
 * @lc app=leetcode id=98 lang=rust
 *
 * [98] Validate Binary Search Tree
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
    pub fn is_valid_bst(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        let mut st: Vec<Rc<RefCell<TreeNode>>> = Vec::new();
        let mut current = root;
        let mut first = true;
        let mut prev = 0;
        while let Some(mut node) = current {
            while node.borrow().left.is_some() {
                st.push(node.clone());
                let o = node.borrow().left.clone();
                node = o.unwrap();
            }
            while node.borrow().right.is_none() && !st.is_empty() {
                if first {
                    first = false;
                } else if prev >= node.borrow().val {
                    return false;
                }
                prev = node.borrow().val;
                node = st.pop().unwrap();
            }
            if first {
                first = false;
            } else if prev >= node.borrow().val {
                return false;
            }
            prev = node.borrow().val;
            current = node.borrow().right.clone();
        }

        return true;
    }
}
// @lc code=end

