/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
import java.util.HashMap;

public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put(s.charAt(0), 0);
		int b = 0, e = 0, max = 1;
		for (int i = 1, len = s.length(); i < len; ++i) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				int p = map.get(c);
				if (p >= b) b = p+1;
			}
			e = i;
			if (e-b+1 > max) max = e-b+1;
			map.put(c, i);
		}
		return max;
	}
}
