/*
 * @lc app=leetcode id=69 lang=rust
 *
 * [69] Sqrt(x)
 */

// @lc code=start
impl Solution {
    pub fn my_sqrt(x: i32) -> i32 {
        let mut s = 0;
        let mut e = x;
        while s <= e {
            let m = s + ((e - s) >> 1);
            let pow = m * m;
            if pow == x {
                return m;
            }
            if pow > x || pow < 0 {
                e -= 1;
            } else if (m + 1) * (m + 1) > x || (m + 1) * (m + 1) < 0 {
                return m;
            } else {
                s += 1;
            }
        }

        0
    }
}
// @lc code=end

