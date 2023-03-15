/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int[] had = new int[256];
        int[] found = new int[256];
        for (char c : t.toCharArray()) {
            had[c]++;
        }
        
        String result = "";
        int count = 0, m = s.length(), n = t.length();
        int min = m;
        for (int start = 0, end = 0; end < m; end++) {
            char c = s.charAt(end);
            found[c]++;
            if (had[c] == 0) {
                continue;
            }
            if (found[c] <= had[c]) {
                count++;
            }
            if (count == n) {
                char sc = s.charAt(start);
                while (found[sc] > had[sc]) {
                    start++;
                    found[sc]--;
                    sc = s.charAt(start);
                }
                if (end - start < min) {
                    min = end - start;
                    result = s.substring(start, end + 1);
                }
                count--;
                start++;
                found[sc]--;
            }
        }

        return result;
    }
}
// @lc code=end

