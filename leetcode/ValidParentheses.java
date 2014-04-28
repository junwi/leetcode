import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') return false;
                    else break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') return false;
                    else break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') return false;
                    else break;
            }
        }
        
        return stack.empty();
    }
}
