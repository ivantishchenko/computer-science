class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 0:
            return 0

        dp = [1] + (n - 1) * [0]
        res = 1
        for i in range(1, n):
            max_val = 0
            for j in range(i):
                if nums[j] < nums[i]:
                    max_val = max(max_val, dp[j])
            dp[i] = max_val + 1
            res = max(res, dp[i])
        return res
