/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int sum = 0, n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I': {
                    sum++;
                    if (i < n - 1) {
                        if (s.charAt(i + 1) == 'V') {
                            sum += 3;
                            i++;
                        } else if (s.charAt(i + 1) == 'X') {
                            sum += 8;
                            i++;
                        }
                    }
                    break;
                }
                case 'V': {
                    sum += 5;
                    break;
                }
                case 'X': {
                    sum += 10;
                    if (i < n - 1) {
                        if (s.charAt(i + 1) == 'L') {
                            sum += 30;
                            i++;
                        } else if (s.charAt(i + 1) == 'C') {
                            sum += 80;
                            i++;
                        }
                    }
                    break;
                }
                case 'L': {
                    sum += 50;
                    break;
                }
                case 'C': {
                    sum += 100;
                    if (i < n - 1) {
                        if (s.charAt(i + 1) == 'D') {
                            sum += 300;
                            i++;
                        } else if (s.charAt(i + 1) == 'M') {
                            sum += 800;
                            i++;
                        }
                    }
                    break;
                }
                case 'D': {
                    sum += 500;
                    break;
                }
                case 'M': {
                    sum += 1000;
                    break;
                }
            }
        }

        return sum;
    }
}
// @lc code=end

