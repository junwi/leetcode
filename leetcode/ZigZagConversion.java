/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null) return null;
		if (nRows == 1) return s;
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		int step = nRows + nRows - 2;
		for (int i = 0; i < nRows; ++i) {
			int index = i;
			while (index < len) {
				sb.append(s.charAt(index));
				index += step;
				if (i != 0 && i != nRows - 1 && index - i - i < len) {
					sb.append(s.charAt(index - i - i));
				}
			}
		}
		return sb.toString();
	}
}
