#
# @lc app=leetcode id=34 lang=python3
#
# [34] Find First and Last Position of Element in Sorted Array
#

# @lc code=start
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.findFirst(nums, target), self.findLast(nums, target)]

    def findFirst(self, nums: List[int], target: int) -> int:
        s = 0
        e = len(nums) - 1
        while s <= e:
            m = (s + e) // 2
            if nums[m] == target:
                if m == 0 or nums[m - 1] < target:
                    return m
                else:
                    e = m - 1
            elif nums[m] > target:
                e = m - 1
            else:
                s = m + 1
        return -1
    
    def findLast(self, nums: List[int], target: int) -> int:
        s = 0
        e = len(nums) - 1
        while s <= e:
            m = (s + e) // 2
            if nums[m] == target:
                if m == len(nums) - 1 or nums[m + 1] > target:
                    return m
                else:
                    s = m + 1
            elif nums[m] > target:
                e = m - 1
            else:
                s = m + 1
        return -1
        
# @lc code=end

