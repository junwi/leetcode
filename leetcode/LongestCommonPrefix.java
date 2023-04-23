/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		assert(strs != null);
		if (strs.length == 0) return "";
		int i = 0;
		boolean flag = true;
		while (flag) {
			if (strs[0].length() == i) break;
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; ++j) {
				if (strs[j].length() == i || strs[j].charAt(i) != c) {
					flag = false;
					break;
				}
			}
			if (flag) ++i;
		}
		return strs[0].substring(0, i);
	}
}
