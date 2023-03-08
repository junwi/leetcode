/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
    private int[] initFactors(int n) {
        int[] factors = new int[n];
        factors[0] = 1;
        for (int i = 1; i < n; i++) {
            factors[i] = factors[i - 1] * i;
        }

        return factors;
    }

    public String getPermutation(int n, int k) {
        int[] factors = initFactors(n);
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n + 1];
        while (sb.length() < n) {
            for (int i = 1; i <= n; i++) {
                if (used[i]) continue;
                int cnt = factors[n - sb.length() - 1];
                if (k > cnt) {
                    k -= cnt;
                    continue;
                }
                sb.append(i);
                used[i] = true;
                break;
            }
        }
        
        return sb.toString();
    }
}
// @lc code=end

