/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/
public class Solution {
	public void setZeroes(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		assert(matrix != null);
		boolean firstRowZero = false, firstColumnZero = false;
		int width = matrix.length;
		if (width < 1) return;
		int height = matrix[0].length;
		if (height < 1) return;
		for (int i = 0; i < width; ++i) {
			if (matrix[i][0] == 0) {
				firstRowZero = true;
				break;
			}
		}
		for (int j = 0; j < height; ++j) {
			if (matrix[0][j] == 0) {
				firstColumnZero = true;
				break;
			}
		}
		for (int i = 1; i < width; ++i) {
			for (int j = 1; j < height; ++j) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < width; ++i) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < height; ++j) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = 1; j < height; ++j) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < width; ++i) {
					matrix[i][j] = 0;
				}
			}
		}
		if (firstRowZero) {
			for (int i = 0; i < width; ++i) {
				matrix[i][0] = 0;
			}
		}
		if (firstColumnZero) {
			for (int j = 0; j < height; ++j) {
				matrix[0][j] = 0;
			}
		}
	}
}
