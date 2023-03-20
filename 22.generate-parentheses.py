#
# @lc app=leetcode id=22 lang=python3
#
# [22] Generate Parentheses
#

# @lc code=start
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []

        self.generate(n, n, 0, [None] * (2 * n), result)

        return result

    def generate(self, left: int, right: int, pos: int, chars: List[str], result: List[str]):
        if right == 0:
            result.append(''.join(chars))
            return
        if left == right:
            chars[pos] = '('
            self.generate(left - 1, right, pos + 1, chars, result)
        elif left == 0:
            chars[pos] = ')'
            self.generate(left, right - 1, pos + 1, chars, result)
        else:
            chars[pos] = '('
            self.generate(left - 1, right, pos + 1, chars, result)
            chars[pos] = ')'
            self.generate(left, right - 1, pos + 1, chars, result)
                
# @lc code=end

