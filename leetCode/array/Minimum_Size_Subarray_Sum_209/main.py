import sys


class Solution:
    def minSubArrayLen(self, s, nums):
        j = 0
        local_sum = 0
        res = sys.maxsize
        for i in range(len(nums)):
            local_sum += nums[i]
            while local_sum >= s:
                res = min(res, i - j + 1)
                local_sum -= nums[j]
                j += 1
        return 0 if res == sys.maxsize else res
