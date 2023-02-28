/*
 * @lc app=leetcode id=7 lang=cpp
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
public:
    int reverse(int x) {
        int preMax = INT_MAX / 10;
        int preMin = INT_MIN / 10;
        int result = 0;
        while (x != 0) {
            int n = x % 10;
            if (result > preMax || (result == preMax && n > 7)) {
                return 0;
            }
            if (result < preMin || (result == preMin && n < -8)) {
                return 0;
            }
            result = result * 10 + n;
            x /= 10;
        }

        return result;
    }
};
// @lc code=end

