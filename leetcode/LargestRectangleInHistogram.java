/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
*/
import java.util.LinkedList;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		assert(height != null);
		int max = 0, i = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		while (i <= height.length) {
			if (stack.isEmpty() || (i < height.length && height[i] > height[stack.peek()])) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				int len = (stack.isEmpty() ? i : (i - stack.peek() - 1));
				int area = height[t] * len;
				if (area > max) max = area;
			}
		}
		return max;
	}
}
