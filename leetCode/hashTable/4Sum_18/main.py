class Solution:
    def twoSum(self, nums, target):
        num_set = set()
        res = []
        for val in nums:
            if target - val in num_set:
                res.append([target - val, val])
            num_set.add(val)
        return res

    def helper(self, nums, target, k):
        if k == 2:
            return self.twoSum(nums, target)
        res = set()
        for i in range(len(nums) - k + 1):
            candidates = self.helper(nums[i + 1:], target - nums[i], k - 1)
            for c in candidates:
                res.add(tuple([nums[i]] + list(c)))
        return res

    def fourSum(self, nums, target):
        if not nums:
            return nums
        nums.sort()
        return self.helper(nums, target, 4)

a = Solution()
a.fourSum([0, 0, 0, 0], 0)