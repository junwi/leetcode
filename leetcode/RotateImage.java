/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/
public class Solution {
	public void rotate(int[][] matrix) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		int n = matrix.length - 1;
		for (int i = 0; (i << 1) < n + 1; ++i) {
			int b = i, e = n - i;
			for (int j = 0; j < e - i; ++j) {
				int temp = matrix[i+j][i];
				matrix[i+j][i] = matrix[e][i+j];
				matrix[e][i+j] = matrix[e-j][e];
				matrix[e-j][e] = matrix[i][e-j];
				matrix[i][e-j] = temp;
			}
		}
	}
}
