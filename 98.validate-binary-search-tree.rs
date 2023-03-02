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
type OptNode = Option<Rc<RefCell<TreeNode>>>;
impl Solution {
    pub fn is_valid_bst(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        Self::is_valid(root, None, None)
    }

    fn is_valid(root: OptNode, left: OptNode, right: OptNode) -> bool {
        if let Some(node) = root {
            if let Some(l) = left.clone() {
                if l.borrow().val >= node.borrow().val {
                    return false;
                }
            }
            if let Some(r) = right.clone() {
                if r.borrow().val <= node.borrow().val {
                    return false;
                }
            }
            return Self::is_valid(node.borrow().left.clone(), left.clone(), Some(node.clone())) && Self::is_valid(node.borrow().right.clone(), Some(node.clone()), right.clone());
        }
        true
    }
}
// @lc code=end

