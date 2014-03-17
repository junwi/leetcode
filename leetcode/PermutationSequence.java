/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

public class Solution {
	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int factorial = 1;
		for (int i = 2; i <= n; ++i) {
			factorial *= i;
		}
		String result = "";
		boolean[] used = new boolean[n+1];
		int no = n;
		while (result.length() < no) {
			int j = 1;
			factorial /= n;
			while (k > 0) {
				if (!used[j]) {
					k -= factorial;
				}
				++j;
			}
			used[j-1] = true;
			result += j-1;
			k += factorial;
			--n;
		}
		return result;
	}
}
