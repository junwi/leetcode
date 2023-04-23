/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/
public class Regular Expression Matching {
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (p.isEmpty()) return s.isEmpty();

		return match(s, 0, p, 0);
	}

	private boolean match(String s, int i, String p, int j) {
		do {
			if (j < p.length()-1 && p.charAt(j+1) == '*') return matchStar(p.charAt(j), s, i, p, j+2);
			if (i >= s.length() && j >= p.length()) return true;
			if (j >= p.length()) return false;
			if (i >= s.length()) return false;
			if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
				++i;
				++j;
			} else return false;
		} while (true);
	}

	private boolean matchStar(char c, String s, int i, String p, int j) {
		int begin;
		for (begin = i; begin < s.length(); ++begin) {
			if (c == '.' || c == s.charAt(begin)) continue;
			break;
		}
		do {
			if (match(s, begin, p, j)) return true;
		} while (begin-- > i);
		return false;
	}
}
