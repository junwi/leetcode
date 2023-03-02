/*
 * @lc app=leetcode id=1 lang=rust
 *
 * [1] Two Sum
 */

// @lc code=start
use std::collections::HashMap;
impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut m: HashMap<i32, usize> = HashMap::new();
        for i in 0..nums.len() {
            if i > 0 && m.contains_key(&nums[i]) {
                return vec!{m[&nums[i]] as i32, i as i32};
            }
            m.insert(target - nums[i], i);
        }

        return vec!{};
    }
}
// @lc code=end

