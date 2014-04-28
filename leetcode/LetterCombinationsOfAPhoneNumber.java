public class Solution {
	private char[][] base = {{' '}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, 
		{'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		char[] cs = new char[digits.length()];
		placeChar(digits, 0, cs, result);
		return result;
	}

	private void placeChar(String digits, int pos, char[] cs, ArrayList<String> result) {
		if (pos == digits.length()) {
			result.add(new String(cs));
			return;
		}
		char c = digits.charAt(pos);
		int n = c - '0';
		assert(n >= 0 && n <= 9);
		char[] array = base[n];
		for (char ch : array) {
			cs[pos] = ch;
			placeChar(digits, pos+1, cs, result);
		}
	}
}
