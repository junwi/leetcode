public class Solution {
	public String intToRoman(int num) {
		Object[][] array = {
			{1000, "M"},
			{900, "CM"},
			{500, "D"},
			{400, "CD"},
			{100, "C"},
			{90, "XC"},
			{50, "L"},
			{40, "XL"},
			{10, "X"},
			{9, "IX"},
			{5, "V"},
			{4, "IV"},
			{1, "I"}
		};
		StringBuilder sb = new StringBuilder();
		for (Object[] pair : array) {
			int v = (Integer) pair[0];
			while (num >= v) {
				sb.append(pair[1]);
				num -= v;
			}
		}
		return sb.toString();
	}
}
