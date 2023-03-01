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
impl Solution {
    pub fn delete_node(root: Option<Rc<RefCell<TreeNode>>>, key: i32) -> Option<Rc<RefCell<TreeNode>>> {
        if root.is_none() {
            return root;
        }
        let mut current: Rc<RefCell<TreeNode>> = root.clone().unwrap();
        let mut parent: Rc<RefCell<TreeNode>> = current.clone();
        loop {
            if key == current.borrow().val {
                break;
            }
            parent = current.clone();
            if key < current.borrow().val && current.borrow().left.is_some() {
                current = current.clone().borrow().left.clone().unwrap();
            } else if key > current.borrow().val && current.borrow().right.is_some() {
                current = current.clone().borrow().right.clone().unwrap();
            } else {
                break;
            }
        }
        if key != current.borrow().val {
            return root;
        }
        if current.borrow().left.is_some() && current.borrow().right.is_some() {
            let tmp = current.clone();
            parent = current.clone();
            current = current.clone().borrow().right.clone().unwrap();
            while current.borrow().left.is_some() {
                parent = current.clone();
                current = current.clone().borrow().left.clone().unwrap();
            }
            tmp.borrow_mut().val = current.borrow().val;
        }
        if current == root.clone().unwrap() {
            if current.borrow().left.is_some() {
                return current.clone().borrow().left.clone();
            } else {
                return current.clone().borrow().right.clone();
            }
        }
        let mut tmp: Option<Rc<RefCell<TreeNode>>> = None;
        if current.borrow().left.is_some() {
            tmp = current.clone().borrow().left.clone();
        } else {
            tmp = current.clone().borrow().right.clone();
        }
        if parent.borrow().left == Some(current) {
            parent.borrow_mut().left = tmp;
        } else {
            parent.borrow_mut().right = tmp;
        }

        return root;
    }
}
// @lc code=end

