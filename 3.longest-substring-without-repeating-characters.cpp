/*
 * @lc app=leetcode id=3 lang=cpp
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> map;
        int l = 0;
        int result = 0;
        for (int i = 0; i < s.size(); i++) {
            if (map.count(s[i]) > 0 && map[s[i]] >= l) {
                l = map[s[i]] + 1;
            }
            map[s[i]] = i;
            result = max(result, i - l + 1);
        }

        return result;
    }
};
// @lc code=end

