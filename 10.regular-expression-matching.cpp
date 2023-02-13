/*
 * @lc app=leetcode id=10 lang=cpp
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
private:
    bool match(char a, char b) {
        return a == b || b == '.';
    }
public:
    bool isMatch(string s, string p) {
        int n = s.size();
        int m = p.size();
        int mem[n + 1][m + 1];
        mem[0][0] = true;
        for (int i = 1; i <= n; i++) {
            mem[i][0] =  false;
        }
        if (m > 0) {
            mem[0][1] = false;
        }
        for (int j = 2; j <= m; j++) {
            if (p[j - 1] != '*') {
                mem[0][j] = false;
                continue;
            }
            mem[0][j] = mem[0][j - 2];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p[j - 1] == '*') {
                    if (j == 1) {
                        mem[i][j] = false;
                        continue;
                    }
                    mem[i][j] = mem[i][j - 2] || (match(s[i - 1], p[j - 2]) && (mem[i][j - 1] || mem[i - 1][j]));
                    continue;
                }
                if (!mem[i - 1][j - 1]) {
                    mem[i][j] =  false;
                    continue;
                }
                if (match(s[i - 1], p[j - 1])) {
                    mem[i][j] =  true;
                    continue;
                }
                mem[i][j] =  false;
            }
        }

        return mem[n][m];
    }
};
// @lc code=end

