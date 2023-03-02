/*
 * @lc app=leetcode id=151 lang=rust
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
impl Solution {
    pub fn reverse_words(s: String) -> String {
        let vec: Vec<char> = s.chars().collect();
        let mut res = String::new();
        let mut i = vec.len() - 1;
        let mut j = vec.len();
        while i >= 0 {
            if vec[i] == ' ' {
                if j > i + 1 {
                    if !res.is_empty() {
                        res.push(' ');
                    }
                    res.push_str(&s[i+1..j]);
                }
                j = i;
            } else if i == 0 {
                if !res.is_empty() {
                    res.push(' ');
                }
                res.push_str(&s[i..j]);
            }
            if i == 0 {
                break;
            }
            i -= 1;
        }

        return res;
    }
}
// @lc code=end

