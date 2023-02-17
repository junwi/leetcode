/*
 * @lc app=leetcode id=69 lang=cpp
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
public:
    int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int s = 1, e = x;
        while (s <= e) {
            int m = s + ((e - s) >> 1);
            if (m > x / m) {
                e = m - 1;
            } else {
                if (m + 1 > x / (m + 1)) {
                    return m;
                }
                s = m + 1;
            }
        }

        return 0;
    }
};
// @lc code=end

