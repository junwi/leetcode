import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    private char[][] table = {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        solve(digits, sb, result);
        return result;
    }

    private void solve(String digits, StringBuilder sb, List<String> result) {
        if (digits.length() == sb.length()) {
            result.add(sb.toString());
            return;
        }
        int i = digits.charAt(sb.length()) - '2';
        for (char c : table[i]) {
            sb.append(c);
            solve(digits, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end

