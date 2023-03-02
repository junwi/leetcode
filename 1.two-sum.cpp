/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> m;
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            if (!m.empty() && m.count(nums[i]) > 0) {
                res.push_back(m[nums[i]]);
                res.push_back(i);

                return res;
            }
            m[target - nums[i]] = i;
        }

        return res;
    }
};
// @lc code=end

