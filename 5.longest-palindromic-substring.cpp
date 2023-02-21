/*
 * @lc app=leetcode id=5 lang=cpp
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
public:
    string longestPalindrome(string s) {
        int start = 0;
        int len = 0;
        int n = s.size();
        for (int i = 0; i < s.size(); i++) {
            int l = i, r = i;
            while (r < n - 1 && s[l] == s[r + 1]) {
                r++;
                i++;
            }
            while (l > 0 && r < n - 1 && s[l - 1] == s[r + 1]) {
                l--;
                r++;
            }
            int m = r - l + 1;
            if (m > len) {
                len = m;
                start = l;
            }
        }

        return s.substr(start, len);
    }
};
// @lc code=end

