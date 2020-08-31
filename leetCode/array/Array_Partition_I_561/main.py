class Solution:
    def arrayPairSum(self, nums):
        nums.sort()

        res = 0
        for i in range(0, len(nums) - 1, 2):
            res += nums[i]

        return res

a = Solution()
out = a.arrayPairSum([1,4,3,2])
pass