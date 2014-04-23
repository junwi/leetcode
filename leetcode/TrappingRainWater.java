public class Solution {
    public int trap(int[] A) {
        if (A.length == 0) return 0;
        int[] valids = new int[A.length];
        int[] areas = new int[A.length];
        int[] bars = new int[A.length];
        int index = 0;
        valids[0] = 0;
        areas[0] = 0;
        bars[0] = A[0];
        for (int i = 1; i < A.length; ++i) {
            bars[i] = bars[i - 1] + A[i];
            int j = index;
            assert(index <= i - 1);
            assert(j <= i - 1);
            while (j >= 0) {
                if (A[valids[j]] >= A[i]) break;
                j--;
            }
            if (j < 0) {
                areas[i] = calcArea(valids[0], i, bars, A) + areas[valids[0]];
                valids[0] = i;
                index = 0;
            } else if (A[valids[j]] == A[i]) {
                areas[i] = calcArea(valids[j], i, bars, A) + areas[valids[j]];
                valids[j] = i;
                index = j;
            } else {
                areas[i] = calcArea(valids[j], i, bars, A) + areas[valids[j]];
                valids[j + 1] = i;
                index = j + 1;
            }
        }
        return areas[A.length - 1];
    }
    
    private int calcArea(int from, int to, int[] bars, int[] A) {
        int h = A[from] >= A[to] ? A[to] : A[from];
        int w = to - from - 1;
        int area = h * w - (bars[to - 1] - bars[from]);
        return area;
    }
}
