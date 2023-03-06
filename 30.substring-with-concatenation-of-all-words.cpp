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
                ++map[str];
                if (map[str] <= wordCount[str]) {
                    ++count;
                }
                if (count == words.size()) {
                    string str = s.substr(l, m);
                    while (map[str] > wordCount[str]) {
                        l += m;
                        --map[str];
                        str = s.substr(l, m);
                    }
                    int len = r - l;
                    if (len == (words.size() - 1) * m) {
                        res.push_back(l);
                    }
                    --map[str];
                    --count;
                    l += m;
                }
            }
        }

        return res;
    }
};
// @lc code=end

