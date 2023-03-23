#
# @lc app=leetcode id=28 lang=python
#
# [28] Find the Index of the First Occurrence in a String
#

# @lc code=start
class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        m = len(haystack)
        n = len(needle)
        next = [None] * n
        self.genNext(needle, next)
        i = 0
        j = 0
        while i < m and j < n:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
            elif j == 0:
                i += 1
            else:
                j = next[j]
        if j == n:
            return i - j
        return -1

        
    def genNext(self, needle, next):
        if len(next) == 1:
            return
        next[1] = 0
        m = len(needle)
        i = 2
        pos = 0
        while i < m:
            if needle[i - 1] == needle[pos]:
                pos += 1
                next[i] = pos
                i += 1
            elif pos == 0:
                next[i] = 0
                i += 1
            else:
                pos = next[pos]

# @lc code=end

