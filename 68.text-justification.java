import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */

// @lc code=start
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int s = 0, n = words.length;
        List<String> result = new ArrayList<>();
        while (s < n) {
            int e = s;
            int l = 0;
            while (e < n) {
                int t = l + words[e].length();
                if (l > 0) {
                    t++;
                }
                if (t > maxWidth) {
                    break;
                }
                l = t;
                e++;
            }
            int gap = maxWidth - l;
            int num = e - s;
            StringBuilder sb = new StringBuilder();
            if (num == 1) {
                sb.append(words[s++]);
                sb.append(" ".repeat(gap));
            } else if (e == n) {
                sb.append(words[s++]);
                while (s < e) {
                    sb.append(' ');
                    sb.append(words[s++]);
                }
                sb.append(" ".repeat(gap));
            } else {
                int avg = gap / (num - 1) + 1;
                int more = gap % (num - 1);
                sb.append(words[s++]);
                while (s < e) {
                    sb.append(" ".repeat(avg));
                    if (more > 0) {
                        sb.append(" ");
                        more--;
                    }
                    sb.append(words[s++]);
                }
            }

            result.add(sb.toString());
        }

        return result;
    }
}
// @lc code=end

