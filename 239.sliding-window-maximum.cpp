/*
 * @lc app=leetcode id=239 lang=cpp
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
private:
    void push(deque<int>& q, int n) {
        while (!q.empty() && q.back() < n) {
            q.pop_back();
        }
        q.push_back(n);
    }
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<int> q;
        vector<int> v;
        int i = 0;
        for (; i < k - 1; i++) {
            push(q, nums[i]);
        }
        for (; i < nums.size(); i++) {
            push(q, nums[i]);
            v.push_back(q.front());
            if (nums[i - k + 1] == q.front()) {
                q.pop_front();
            }
        }

        return v;
    }
};
// @lc code=end

