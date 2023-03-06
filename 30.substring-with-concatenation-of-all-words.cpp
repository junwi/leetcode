/*
 * @lc app=leetcode id=30 lang=cpp
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        int m = words[0].size();
        int n = s.size();
        int min = 0;
        vector<int> res;
        unordered_map<string, int> wordCount;
        for (auto word : words) {
            ++wordCount[word];
        }
        for (int i = 0; i < m; i++) {
            int count = 0;
            unordered_map<string, int> map;
            for (int l = i, r = i; r + m <= n; r += m) {
                string str = s.substr(r, m);
                if (wordCount.count(str) == 0) {
                    l = r + m;
                    count = 0;
                    map.clear();
                    continue;
                }
                ++map[str];
                if (map[str] <= wordCount[str]) {
                    ++count;
                }
                while (map[str] > wordCount[str]) {
                    string left = s.substr(l, m);
                    if (map[left] <= wordCount[left]) {
                        --count;
                    }
                    --map[left];
                    l += m;
                }
                if (count == words.size()) {
                    res.push_back(l);
                    --map[s.substr(l, m)];
                    --count;
                    l += m;
                }
            }
        }

        return res;
    }
};
// @lc code=end

