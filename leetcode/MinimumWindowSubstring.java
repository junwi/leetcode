/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/
import java.util.HashMap;

public class Solution {
	public String minWindow(String S, String T) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		int[] need = new int[256];
		int[] found = new int[256];
		String result = "";
		int count = 0;
		for (int i = 0; i < T.length(); ++i) {
			++need[T.charAt(i)];
		}
		for (int begin = 0, end = 0; end < S.length(); ++end) {
			char c = S.charAt(end);
			if (need[c] == 0) continue;
			if (found[c] < need[c]) ++count;
			++found[c];
			if (count == T.length()) {
				while (need[S.charAt(begin)] == 0 || found[S.charAt(begin)] > need[S.charAt(begin)]) {
					if (found[S.charAt(begin)] > need[S.charAt(begin)]) --found[S.charAt(begin)];
					++begin;
				}
				if (result.isEmpty()) result = S.substring(begin, end+1);
				else if (end+1-begin < result.length()) result = S.substring(begin, end+1);
			}
		}
		return result;
	}
}
