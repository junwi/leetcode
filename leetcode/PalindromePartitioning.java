/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
      ["aa","b"],
      ["a","a","b"]
  ]
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class Solution {
	public ArrayList<ArrayList<String>> partition(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		assert(s != null);
		LinkedList<int[]> list = new LinkedList<int[]>();
		list.add(new int[] {0});
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s.isEmpty()) return result;
		ArrayList<String> zero = new ArrayList<String>();
		zero.add(s.substring(0,1));
		result.add(zero);
		ArrayList<ArrayList<ArrayList<String>>> total = new ArrayList<ArrayList<ArrayList<String>>>();
		total.add(result);
		for (int i = 1; i < s.length(); ++i) {
			Iterator<int[]> it = list.iterator();
			while (it.hasNext()) {
				int[] first = it.next();
				if (first[0] == 0 || s.charAt(first[0]-1) != s.charAt(i)) {
					it.remove();
					continue;
				}
				first[0] -= 1;
			}
			if (s.charAt(i) == s.charAt(i-1)) {
				list.add(new int[] {i-1});
			}
			list.add(new int[] {i});
			if (total.size() < i+1) {
				total.add(new ArrayList<ArrayList<String>>());
			}
			ArrayList<ArrayList<String>> current = total.get(i);
			for (int[] first : list) {
				if (first[0] == 0) {
					ArrayList<String> cut = new ArrayList<String>();
					cut.add(s.substring(0, i+1));
					current.add(cut);
				} else {
					ArrayList<ArrayList<String>> previous = total.get(first[0]-1);
					for (ArrayList<String> cuts : previous) {
						cuts = (ArrayList<String>) cuts.clone();
						cuts.add(s.substring(first[0], i+1));
						current.add(cuts);
					}
				}
			}
		}
		return total.get(s.length() - 1);
	}
}
