/*
 * @lc app=leetcode id=10 lang=rust
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
impl Solution {
    fn char_match(a: char, b: char) -> bool {
        a == b || b == '.'
    }

    pub fn is_match(s: String, p: String) -> bool {
        let m = s.len();
        let n = p.len();
        let s:Vec<char> = s.chars().collect();
        let p:Vec<char> = p.chars().collect();
        let mut mem = vec![vec![false; n + 1]; m + 1];
        mem[0][0] = true;
        for i in 1..=m {
            mem[i][0] = false;
        }
        if m > 0 {
            mem[0][1] = false;
        }
        for j in 2..=n {
            if p[j - 1] == '*' {
                mem[0][j] = mem[0][j - 2];
            } else {
                mem[0][j] = false;
            }
        }
        for i in 1..=m {
            for j in 1..=n {
                if p[j - 1] == '*' {
                    if j == 1 {
                        mem[i][j] = false;
                        continue;
                    }
                    mem[i][j] = mem[i][j - 2] || (Self::char_match(s[i - 1], p[j - 2]) && (mem[i][j - 1] || mem[i - 1][j]));
                    continue;
                }
                mem[i][j] = mem[i - 1][j - 1] && Self::char_match(s[i - 1], p[j - 1]);
            }
        }

        mem[m][n]
    }
}
// @lc code=end

