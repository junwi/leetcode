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
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        int distance = 1;
        Set<String> begin = new HashSet<>();
        begin.add(beginWord);
        while (!words.isEmpty()) {
            begin = adjacent(begin, words);
            if (begin.isEmpty()) {
                return 0;
            }
            distance++;
            if (begin.contains(endWord)) {
                return distance;
            }
            words.removeAll(begin);
        }

        return distance;
    }

    private Set<String> adjacent(Set<String> set, Set<String> words) {
        Set<String> adjacents = new HashSet<>();
        for (String s : words) {
            for (String b : set) {
                if (isAdjacent(s, b)) {
                    adjacents.add(s);
                }
            }
        }

        return adjacents;
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

