import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                default:
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        if (c == ')' && stack.pop() != '(') {
                            return false;
                        }
                        if (c == ']' && stack.pop() != '[') {
                            return false;
                        }
                        if (c == '}' && stack.pop() != '{') {
                            return false;
                        }
                    }
            }
        }

        return stack.isEmpty();
    }
}
// @lc code=end

