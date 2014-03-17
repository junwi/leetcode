/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 0) return false;
		int end = 1;
		while (x / end > 9) end *= 10;
		int begin = 10;
		while (x > 9) {
			if (x / end != x % begin) return false;
			x = (x % end) / begin;
			end /= 100;
		}
		return true;
	}
}
