class Solution:
    def two_sum(self, nums, target, res):
        # two sum
        sum_set = set()
        for v in nums:
            if target - v in sum_set:
                res.add((v, target - v, -target))
            sum_set.add(v)

    def threeSum(self, nums):
        nums.sort()
        res = set()
        n = len(nums)
        for i in range(n):
            self.two_sum(nums[i + 1:], -nums[i], res)

        return res
