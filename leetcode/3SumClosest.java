import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int gap = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < num.length - 2; ++i) {
            int s = i + 1;
            int e = num.length - 1;
            while (s < e) {
                int sum = num[i] + num[s] + num[e];
                int t = sum - target;
                if (t == 0) return target;
                if (t > 0) {
                    --e;
                } else {
                    ++s;
                    t = -t;
                }
                if (t < gap) {
                    gap = t;
                    result = sum;
                }
            }
        }
        
        return result;
    }
}
