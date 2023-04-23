/*
Divide two integers without using multiplication, division and mod operator.
*/
public class Solution {
	public int divide(int dividend, int divisor) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		assert(divisor != 0);
		int sign = 1;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;
		return sign * divide1(dividend, divisor);
	}

	private int divide1(long dividend, long divisor) {
		dividend = dividend > 0 ? dividend : -dividend;
		divisor = divisor > 0 ? divisor : -divisor;
		return (int) divide2(dividend, divisor)[0];
	}

	private long[] divide2(long dividend, long divisor) {
		if (dividend < divisor) return new long[] {0, dividend};
		if (dividend < divisor + divisor) return new long[] {1, dividend-divisor};
		long[] result = divide2(dividend, divisor + divisor);
		if (result[1] < divisor) return new long[] {result[0] + result[0], result[1]};
		return new long[] {result[0] + result[0] + 1, result[1] - divisor};
	}
}
