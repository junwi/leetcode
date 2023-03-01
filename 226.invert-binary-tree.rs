/*
 * @lc app=leetcode id=226 lang=rust
 *
 * [226] Invert Binary Tree
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
    pub fn invert_tree(root: Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
        if root.is_none() {
            return root;
        }
        let node = root.clone().unwrap();
        Self::invert_tree(node.clone().borrow().left.clone());
        Self::invert_tree(node.clone().borrow().right.clone());
        let mut n = node.borrow_mut();
        let n = &mut *n;
        std::mem::swap(&mut n.left, &mut n.right);

        return root;
    }
}
// @lc code=end

