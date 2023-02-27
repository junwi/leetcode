/*
 * @lc app=leetcode id=450 lang=rust
 *
 * [450] Delete Node in a BST
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
use std::ops::Deref;
impl Solution {
    pub fn delete_node(root: Option<Rc<RefCell<TreeNode>>>, key: i32) -> Option<Rc<RefCell<TreeNode>>> {
        let mut current: &Option<Rc<RefCell<TreeNode>>> = &root;
        let mut parent: &Option<Rc<RefCell<TreeNode>>>;
        while let Some(node) = current {
            if node.borrow().val == key {
                break;
            }
            parent = current;
            if node.borrow().val > key {
                current = &node.borrow().deref().left;
            } else {
                current = &node.borrow().right;
            }
        }
        if current.is_none() {
            return root;
        }
        if let Some(node) = current {
            if node.borrow().left.is_some() && node.borrow().right.is_some() {
                let mut tmp = node;
                parent = current;
                current = &node.borrow().right;
                while let Some(n) = current {
                    if n.borrow().left.is_some() {
                        parent = current;
                        current = &n.borrow().left;
                    } else {
                        tmp.borrow().val = n.borrow().val;
                        break;
                    }
                }
            }
        }
        if let Some(node) = current {
            if parent.is_none() {
                if node.borrow().left.is_some() {
                    return node.borrow().left;
                } else {
                    return node.borrow().right;
                }
            }
            let mut tmp: Option<Rc<RefCell<TreeNode>>> = None;
            if node.borrow().left.is_some() {
                tmp = node.borrow().left;
            } else {
                tmp = node.borrow().right;
            }
            if let Some(p) = parent {
                if p.borrow().left == *current {
                    p.borrow().left = tmp;
                } else {
                    p.borrow().right = tmp;
                }
            }
        }

        return root;
    }
}
// @lc code=end

