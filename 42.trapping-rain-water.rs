/*
 * @lc app=leetcode id=42 lang=rust
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
impl Solution {
    pub fn trap(height: Vec<i32>) -> i32 {
        use std::cmp;

        let n = height.len();
        let mut rmax = vec![0; n];
        rmax[n - 1] = height[n - 1];
        for i in (0..n-1).rev() {
            if height[i] > rmax[i + 1] {
                rmax[i] = height[i];
            } else {
                rmax[i] = rmax[i + 1];
            }
        }
        let mut max = height[0];
        let mut water = 0;
        for i in 1..n-1 {
            let h = cmp::min(max, rmax[i + 1]) - height[i];
            if h > 0 {
                water += h;
            }
            if max < height[i] {
                max = height[i];
            }
        }

        water
    }
}
// @lc code=end

