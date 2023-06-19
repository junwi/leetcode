/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int end = compact(chars);
        reverse(chars, 0, end);
        reverseWord(chars, end);

        return new String(chars, 0, end + 1);
    }

    private int compact(char[] chars) {
        int end = 0, n = chars.length;
        boolean space = true;
        for (int i = 0; i < n; i++) {
            if (chars[i] != ' ') {
                space = false;
                chars[end++] = chars[i];
            } else {
                if (!space) {
                    chars[end++] = chars[i];
                }
                space = true;
            }
        }
        if (chars[end - 1] == ' ') {
            end--;
        }

        return end - 1;
    }

    private void reverseWord(char[] chars, int end) {
        int l = 0, r = 0;
        while (r <= end) {
            if (r == end || chars[r + 1] == ' ') {
                reverse(chars, l, r);
                l = r + 2;
            }
            r++;
        }
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
}
// @lc code=end

