/*
 * @lc app=leetcode id=84 lang=cpp
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<int> st;
        int i = 0;
        int max = 0;
        int n = heights.size();
        while (i <= n) {
            if (st.empty() || (i < n && heights[i] > heights[st.top()])) {
                st.push(i++);
            } else {
                int h = heights[st.top()];
                st.pop();
                int w = st.empty() ? i : (i - 1 - st.top());
                int area = h * w;
                max = area > max ? area : max;
            }
        }

        return max;
    }
};
// @lc code=end

