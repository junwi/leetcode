/*
 * @lc app=leetcode id=1539 lang=cpp
 *
 * [1539] Kth Missing Positive Number
 */

// @lc code=start
class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        int m = arr.size();
        int n = m + k;
        for (int i = 0, index = 0; i < n; i++) {
            if (index < m && arr[index] == i + 1) {
                index++;
            } else {
                k--;
                if (k == 0) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
};
// @lc code=end

