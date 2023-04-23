public class RomanToInteger {

	public class Solution {
		public int romanToInt(String s) {
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
			int result = 0;
			for (Object[] pair : array) {
				int v = (Integer) pair[0];
				while (s.startsWith((String) pair[1])) {
					result += v;
					s = s.substring(((String) pair[1]).length());
				}
			}
			return result;
		}
	}
}
