/*
 * @lc app=leetcode id=11 lang=rust
 *
 * [11] Container With Most Water
 */

// @lc code=start
impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        use std::cmp;

        let mut left = 0;
        let mut right = height.len() - 1;
        let mut area = 0;
        while left < right {
            let n = (right - left) as i32;
            let m:i32;
            if height[left] < height[right] {
                m = height[left];
                left += 1;
            } else {
                m = height[right];
                right -= 1;
            }
            let a = m * n;
            area = if a > area { a } else { area};
        }

        area
    }
}
// @lc code=end

