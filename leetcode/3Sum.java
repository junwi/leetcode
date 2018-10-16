import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 2; ++i) {
            int s = i + 1;
            int e = num.length - 1;
            while (s < e) {
                int sum = num[i] + num[s] + num[e];
                if (sum == 0) {
                    boolean flag = true;
                    for (int j = result.size() - 1; j >= 0; --j) {
                        ArrayList<Integer> list = result.get(j);
                        if (list.get(0) < num[i]) break;
                        if (list.get(1) < num[s]) break;
                        if (list.get(1) == num[s]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[s]);
                        list.add(num[e]);
                        result.add(list);
                    }
                    ++s;
                    --e;
                } else if (sum < 0) ++s;
                else --e;
            }
        }

        return result;
    }
}
