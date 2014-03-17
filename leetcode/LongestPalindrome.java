/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
import java.util.LinkedList;

public class LongestPalindrome {
	public String longestPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null) return null;
		if (s.length() == 0) return s;
		int b = 0, e = 0;
		LinkedList<int[]> list = new LinkedList<int[]>();
		list.add(new int[] {0});
		for (int i = 1; i < s.length(); ++i) {
			Iterator<int[]> it = list.iterator();
			while (it.hasNext()) {
				int[] entry = it.next();
				if (entry[0]-1 >= 0 && s.charAt(entry[0]-1) == s.charAt(i)) {
					--entry[0];
					if (i-entry[0] > e-b) {
						b = entry[0];
						e = i;
					}
				} else {
					it.remove();
				}
			}
			if (s.charAt(i) == s.charAt(i-1)) {
				int[] entry = new int[1];
				entry[0] = i-1;
				list.add(entry);
				if (e-b < 1) {
					b = i-1;
					e = i;
				}
			}
			int[] entry = new int[1];
			entry[0] = i;
			list.add(entry);
		}
		return s.substring(b, e+1);
	}
}
