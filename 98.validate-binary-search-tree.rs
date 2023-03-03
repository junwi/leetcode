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
        fn is_valid(root: &OptNode, left: Option<i32>, right: Option<i32>) -> bool {
            match root.as_ref() {
                None => true,
                Some(node) => {
                    let node = node.borrow();
                    if left.is_some() && left.unwrap() >= node.val {
                        return false;
                    }
                    if right.is_some() && right.unwrap() <= node.val {
                        return false;
                    }
                    is_valid(&node.left, left, Some(node.val)) && is_valid(&node.right, Some(node.val), right)
                }
            }
        }

        is_valid(&root, None, None)
    }
}
// @lc code=end

