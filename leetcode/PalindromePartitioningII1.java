/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/
import java.util.LinkedList;
import java.util.Iterator;

public class Solution {

	public int minCut(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		assert(s != null);
		if (s.isEmpty()) return 0;
		int[] mins = new int[s.length()];
		LinkedList<int[]> list = new LinkedList<int[]>();
		list.add(new int[] {0});
		mins[0] = 0;
		for (int i = 1; i < s.length(); ++i) {
			list.add(new int[] {i});
			list.add(new int[] {i+1});
			Iterator<int[]> it = list.iterator();
			int min = i;
			while (it.hasNext()) {
				int[] first = it.next();
				if (first[0] == 0 || s.charAt(first[0]-1) != s.charAt(i)) {
					it.remove();
					continue;
				}
				first[0] -= 1;
				if (first[0] == 0) {
					min = 0;
				} else {
					int cuts = mins[first[0]-1] + 1;
					if (min > cuts) min = cuts;
				}
			}
			mins[i] = min;
		}
		return mins[s.length()-1];
	}
}
