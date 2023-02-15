/*
 * @lc app=leetcode id=70 lang=rust
 *
 * [70] Climbing Stairs
 */

// @lc code=start
impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        match n {
            1 => 1,
            2 => 2,
            _ => {
                let mut f1 = 1;
                let mut f2 = 2;
                let mut f3 = 0;
                for i in 3..=n {
                    f3 = f1 + f2;
                    f1 = f2;
                    f2 = f3;
                }
                f3
            }
        }
    }
}
// @lc code=end

