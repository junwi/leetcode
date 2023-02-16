/*
 * @lc app=leetcode id=11 lang=c
 *
 * [11] Container With Most Water
 */

// @lc code=start
int maxArea(int* height, int heightSize){
    int water = 0, *i = height, *j = i + heightSize - 1;
    while (i < j) {
        int h = *i < *j ? *i : *j;
        int w = h * (j - i);
        if (w > water) water = w;
        while (*i <= h && i < j) i++;
        while (*j <= h && i < j) j--;
    }

    return water;
}
// @lc code=end

