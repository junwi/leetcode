/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Find the Index of the First Occurrence in a String
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        int[] next = new int[n];
        genNext(needle, next);
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
        }

        return j == n ? i - j : -1;
    }

    private void genNext(String needle, int[] next) {
        if (next.length == 1) {
            return;
        }
        next[1] = 0;
        int i = 2, pos = 0, m = next.length;
        while (i < m) {
            if (needle.charAt(i - 1) == needle.charAt(pos)) {
                next[i++] = ++pos;
            } else if (pos == 0) {
                i++;
            } else {
                pos = next[pos];
            }
        }
    }
}
// @lc code=end

