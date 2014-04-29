public class Solution {
	public int removeElement(int[] A, int elem) {
		int size = 0;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] == elem) continue;
			if (size < i) A[size] = A[i];
			++size;
		}
		return size;
	}
}
