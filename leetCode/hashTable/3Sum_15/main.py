class Solution:
    def two_sum_bin(self, nums, target, res):
        i, j = 0, len(nums) - 1
        while i < j:
            curr_val = nums[i] + nums[j]
            if curr_val > target:
                j -= 1
            elif curr_val < target:
                i += 1
            else:
                res.add((-target, nums[i], nums[j]))
                i += 1
                j -= 1
        return

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
            self.two_sum_bin(nums[i + 1:], -nums[i], res)

        return res