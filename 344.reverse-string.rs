/*
 * @lc app=leetcode id=344 lang=rust
 *
 * [344] Reverse String
 */

// @lc code=start
impl Solution {
    pub fn reverse_string(s: &mut Vec<char>) {
        let mut i = 0;
        let mut j = s.len() - 1;
        while i < j {
            s.swap(i, j);
            i += 1;
            j -= 1;
        }
    }
}
// @lc code=end

