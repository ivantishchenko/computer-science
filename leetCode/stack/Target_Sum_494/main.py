import collections


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
        if not nums or sum(nums) < S: return 0
        dic = {0: 1}
        for i in range(len(nums)):
            temp_dic = collections.defaultdict(int)
            for k in dic:
                temp_dic[k + nums[i]] += dic[k]
                temp_dic[k - nums[i]] += dic[k]
            dic = temp_dic
        return dic[S]
        # memo = {}
        # return self.helper(nums, S, 0, 0, memo)

a  = Solution()
res = a.findTargetSumWays([1, 1, 1, 1, 1], 3)
pass