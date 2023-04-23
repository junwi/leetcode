import java.util.LinkedList;
// Type your Java code and click the "Run Code" button!
// Your code output will be shown on the left.
// Click on the "Show input" button to enter input data to be read (from stdin).

public class Interpreter {
	public static void main(String[] args) {
		// Start typing your code here...
		System.out.println(minDistance("a", "a"));

	}
	public static int minDistance(String word1, String word2) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		int len1 = word1.length();
		int len2 = word2.length();
		int lcs = lcs(word1, word2);
		if (len1 > len2) return len1 - lcs;
		return len2 - lcs;
	}

	private static int lcs(String word1, String word2) {
		int[][] x = new int[word1.length()+1][word2.length()+1];
		for (int i = 0; i < word1.length(); ++i) {
			char c = word1.charAt(i);
			for (int j = 0; j < word2.length(); ++j) {
				if (c == word2.charAt(j)) {
					x[i+1][j+1] = x[i][j]+1;
				} else if (x[i+1][j] > x[i][j+1]) {
					x[i+1][j+1] = x[i+1][j];
				} else {
					x[i+1][j+1] = x[i][j+1];
				}
			}
		}
		return x[word1.length()][word2.length()];
	}
}	
