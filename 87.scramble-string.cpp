/*
 * @lc app=leetcode id=87 lang=cpp
 *
 * [87] Scramble String
 */

// @lc code=start
class Solution {
public:
    bool isScramble(string s1, string s2) {
        int m = s1.size();
        bool mem[m][m][m + 1];
        for (int l = 1; l <= m; l++) {
            for (int i = 0; i <= m - l; i++) {
                for (int j = 0; j <= m - l; j++) {
                    if (l == 1) {
                        mem[i][j][l] = (s1[i] == s2[j]);
                        continue;
                    }
                    for (int t = 1; t < l; t++) {
                        mem[i][j][l] = ((mem[i][j][t] && mem[i + t][j + t][l - t])
                            || (mem[i][j + l - t][t] && mem[i + t][j][l - t]));
                        if (mem[i][j][l]) {
                            break;
                        }
                    }
                }
            }
        }
        return mem[0][0][m];
    }
};
// @lc code=end

