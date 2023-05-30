/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private Set<String> begin = new HashSet<>();
    private Set<String> end = new HashSet<>();
    private Set<String> words;
    private boolean find = false;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        int count = 1;
        begin.add(beginWord);
        end.add(endWord);
        words.remove(endWord);
        while (true) {
            check();
            if (find) {
                return count + 1;
            }
            if (begin.size() > end.size()) {
                swap();
            }
            adjacent();
            if (begin.isEmpty()) {
                return 0;
            }
            count++;
        }
    }

    private void swap() {
        Set<String> tmp = begin;
        begin = end;
        end = tmp;
    }

    private void check() {
        for (String b : begin) {
            for (String e : end) {
                if (isAdjacent(b, e)) {
                    find = true;
                    return;
                }
            }
        }
    }

    private void adjacent() {
        Set<String> adjacents = new HashSet<>();
        for (String s : words) {
            for (String b : begin) {
                if (isAdjacent(s, b)) {
                    adjacents.add(s);
                }
            }
        }
        begin = adjacents;
        words.removeAll(begin);
    }

    private boolean isAdjacent(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }
}
// @lc code=end

