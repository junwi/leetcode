/*
 * @lc app=leetcode id=3 lang=cpp
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int map[256] = {0};
        int l = 0;
        int n = s.size();
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (map[s[i]] > 0 && map[s[i]] >= l) {
                l = map[s[i]];
            }
            map[s[i]] = i + 1;
            result = max(result, i - l + 1);
        }

        return result;
    }
};
// @lc code=end

