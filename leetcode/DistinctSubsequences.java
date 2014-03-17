/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/
import java.util.LinkedList;
// Type your Java code and click the "Run Code" button!
// Your code output will be shown on the left.
// Click on the "Show input" button to enter input data to be read (from stdin).

public class Interpreter {
	public static void main(String[] args) {
		// Start typing your code here...
		System.out.println(numDistinct("rabbbit", "rabbit"));

	}
	private static int numDistinct(String S, String T) {
		int[] occurence = new int[T.length() + 1];
		occurence[0] = 1;
		for(int i = 0; i < S.length(); i++){
			for(int j = T.length() - 1; j >= 0 ; j--) {
				if(S.charAt(i) == T.charAt(j)){
					if(occurence[j] > 0)
						occurence[j + 1] += occurence[j];
				}
			}
		}
		return occurence[T.length()];
	}
}	
