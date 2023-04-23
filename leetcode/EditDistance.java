/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/
public class EditDistance {

	public int editDistance(String word1, String word2) {
		int[] dp = new int[word2.length()+1];
		for (int i = 0; i <= word2.length(); ++i) {
			dp[i] = i;
		}
		for (int i = 0; i < word1.length(); ++i) {
			char c = word1.charAt(i);
			int last = i;
			dp[0] = i+1;
			for (int j = 0; j < word2.length(); ++j) {
				if (c == word2.charAt(j)) {
					int t = dp[j+1];
					dp[j+1] = last;
					last = t;
				} else {
					int min = last, t = dp[j+1];
					if (dp[j] < min) min = dp[j];
					if (dp[j+1] < min) min = dp[j+1];
					dp[j+1] = min+1;
					last = t;
				}
			}
		}
		return dp[word2.length()];
	}
}
