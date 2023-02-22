/*
 * @lc app=leetcode id=151 lang=cpp
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
public:
    string reverseWords(string s) {
        int r = s.size();
        int l = s.size() - 1;
        string str;
        bool empty = true;
        while (l >= 0) {
            if (s[l] == ' ') {
                if (l + 1 < r) {
                    if (!empty) {
                        str += " ";
                    } else {
                        empty = false;
                    }
                    str += s.substr(l + 1, r - l - 1);
                }
                r = l;
            } else if (l == 0) {
                if (!empty) {
                    str += " ";
                }
                str += s.substr(l, r - l);
            }
            l--;
        }

        return str;
    }
};
// @lc code=end

