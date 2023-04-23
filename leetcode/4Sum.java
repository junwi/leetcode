import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int a = 0; a < num.length - 3; ++a) {
            int i = a + 1;
            while (i < num.length - 2) {
                int s = i + 1;
                int e = num.length - 1;
                while (s < e) {
                    int sum = num[a] + num[i] + num[s] + num[e];
                    if (sum == target) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[a]);
                        list.add(num[i]);
                        list.add(num[s]);
                        list.add(num[e]);
                        result.add(list);
                        while (s < e) {
                            if (num[e] == num[e-1]) --e;
                            else break;
                        }
                        --e;
                        while (s < e) {
                            if (num[s] == num[s+1]) ++s;
                            else break;
                        }
                        ++s;
                    } else if (sum > target) {
                        while (s < e) {
                            if (num[e] == num[e-1]) --e;
                            else break;
                        }
                        --e;
                    } else if (sum < target) {
                        while (s < e) {
                            if (num[s] == num[s+1]) ++s;
                            else break;
                        }
                        ++s;
                    }
                }
                while (i < num.length - 2) {
                    if (num[i] == num[i+1]) ++i;
                    else break;
                }
                ++i;
            }
            while (a < num.length - 3) {
                if (num[a] == num[a+1]) ++a;
                else break;
            }
        }
        
        return result;
    }
}
