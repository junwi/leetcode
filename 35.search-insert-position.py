#
# @lc app=leetcode id=35 lang=python3
#
# [35] Search Insert Position
#

# @lc code=start
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        s = 0
        e = len(nums) - 1
        while s <= e:
            m = (s + e) // 2
            if nums[m] == target:
                return m
            elif nums[m] > target:
                if m == 0 or nums[m - 1] < target:
                    return m
                else:
                    e = m - 1
            else:
                if m == len(nums) - 1 or nums[m + 1] > target:
                    return m + 1
                else:
                    s = m + 1
        return -1
        
# @lc code=end

