import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        Map<String, Integer> had = new HashMap<>();
        for (String word : words) {
            had.put(word, had.getOrDefault(word, 0) + 1);
        }
        int m = s.length(), n = words[0].length(), len = words.length;
        Map<String, Integer> found = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int start = i, end = i, count = 0; end + n <= m; end += n) {
                String w = s.substring(end, end + n);
                found.put(w, found.getOrDefault(w, 0) + 1);
                if (had.containsKey(w) && found.get(w).intValue() <= had.get(w).intValue()) {
                    count++;
                }
                if (count == len) {
                    String sw = s.substring(start, start + n);
                    while (!had.containsKey(sw) || found.get(sw).intValue() > had.get(sw).intValue()) {
                        start += n;
                        found.put(sw, found.get(sw) - 1);
                        sw = s.substring(start, start + n);
                    }
                    if (end - start + n == n * len) {
                        result.add(start);
                    }
                    start += n;
                    found.put(sw, found.get(sw) - 1);
                    count--;
                }
            }
            found.clear();
        }
        return result;
    }
}
// @lc code=end

