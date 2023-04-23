/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/
import java.util.LinkedList;

public class Solution {
	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int max = 0, last = -1;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else if (c == ')') {
				if (stack.isEmpty()) {
					last = i;
					continue;
				}
				int p = stack.pop();
				int len;
				if (stack.isEmpty()) {
					len = i - last;
				} else {
					len = i - stack.peek();
				}
				if (max < len) max = len;
			}
		}
		return max;
	}
}
