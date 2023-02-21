/*
 * @lc app=leetcode id=5 lang=rust
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        let st: Vec<char> = s.chars().collect();
        let mut start = 0;
        let mut length = 0;
        let mut i = 0;
        let n = s.len();
        while i < n {
            let mut l = i;
            let mut r = i;
            while r < n - 1 && st[r + 1] == st[l] {
                r += 1;
                i += 1;
            }
            while l > 0 && r < n - 1 && st[l - 1] == st[r + 1] {
                l -= 1;
                r += 1;
            }
            let m = r - l + 1;
            if m > length {
                length = m;
                start = l;
            }
            i += 1;
        }

        String::from(&s[start..start+length])
    }
}
// @lc code=end

