/*
 * @lc app=leetcode id=8 lang=cpp
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
public:
    int myAtoi(string s) {
        int flag = 1;
        int result = 0;
        bool start = false;
        int preMax = INT_MAX / 10;
        int preMin = INT_MIN / 10;
        for (char c : s) {
            if (c == ' ') {
                if (!start) {
                    continue;
                }
                return result;
            }
            if (c == '-') {
                if (start) {
                    return result;
                }
                start = true;
                flag = -1;
            } else if (c == '+') {
                if (start) {
                    return result;
                }
                start = true;
            } else if (isdigit(c)) {
                start = true;
                if (result > preMax) {
                    return INT_MAX;
                } else if (result < preMin) {
                    return INT_MIN;
                } else if (result == preMax && (c - '0' > 7)) {
                    return INT_MAX;
                } else if (result == preMin && (c - '0' > 8)) {
                    return INT_MIN;
                } else if (result == 0) {
                    result = (c - '0') * flag;
                } else if (result > 0) {
                    result = result * 10 + (c - '0');
                } else {
                    result = result * 10 - (c - '0');
                }
            } else {
                return result;
            }
        }

        return result;
    }
};
// @lc code=end

