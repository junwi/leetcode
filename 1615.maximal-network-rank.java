import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=1615 lang=java
 *
 * [1615] Maximal Network Rank
 */

// @lc code=start
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] conns = new boolean[n][n];
        int[] vectics = new int[n];
        for (int[] road : roads) {
            conns[road[0]][road[1]] = true;
            conns[road[1]][road[0]] = true;
            vectics[road[0]]++;
            vectics[road[1]]++;
        }
        int first = 0, second = -1;
        for (int i = 0; i < n; i++) {
            if (vectics[i] > first) {
                second = first;
                first = vectics[i];
            } else if (vectics[i] > second) {
                second = vectics[i];
            }
        }
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (vectics[i] == first) {
                firstList.add(i);
            } else if (vectics[i] == second) {
                secondList.add(i);
            }
        }
        if (firstList.size() > 1) {
            for (int i = 0; i < firstList.size() - 1; i++) {
                int a = firstList.get(i);
                for (int j = i + 1; j < firstList.size(); j++) {
                    int b = firstList.get(j);
                    if (!conns[a][b]) {
                        return first * 2;
                    }
                }
            }
            return first * 2 - 1;
        } else {
            int a = firstList.get(0);
            for (int j = 0; j < secondList.size(); j++) {
                int b = secondList.get(j);
                if (!conns[a][b]) {
                    return first + second;
                }
            }

            return first + second - 1;
        }
    }
}
// @lc code=end

