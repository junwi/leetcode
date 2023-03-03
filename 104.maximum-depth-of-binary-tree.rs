/*
 * @lc app=leetcode id=104 lang=rust
 *
 * [104] Maximum Depth of Binary Tree
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
use std::cmp;
impl Solution {
    pub fn max_depth(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        fn max_depth_rec(root: &Option<Rc<RefCell<TreeNode>>>) ->i32 {
            match root.as_ref() {
                Some(node) => {
                    cmp::max(
                        max_depth_rec(&node.borrow().left),
                        max_depth_rec(&node.borrow().right)
                    ) + 1
                }
                None => 0
            }
        }
        max_depth_rec(&root)
    }
}
// @lc code=end

