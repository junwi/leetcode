public class Solution {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) return 0;
		int size = 1;
		for (int i = 1; i < A.length; ++i) {
			if (A[size-1] == A[i]) continue;
			A[size++] = A[i];
		}
		return size;
	}
}
