class Solution:
    def helper(self, nums, S, sum, i, memo):
        if i == len(nums):
            if sum == S:
                return 1
            else:
                return 0
        else:
            if (i, sum) in memo:
                return memo[(i, sum)]
            add = self.helper(nums, S, nums[i] + sum, i + 1, memo)
            sub = self.helper(nums, S, -nums[i] + sum, i + 1, memo)
            memo[(i, sum)] = add + sub
            return memo[(i, sum)]

    def findTargetSumWays(self, nums, S):
        memo = {}
        return self.helper(nums, S, 0, 0, memo)

a  = Solution()
res = a.findTargetSumWays([1, 1, 1, 1, 1], 3)
pass