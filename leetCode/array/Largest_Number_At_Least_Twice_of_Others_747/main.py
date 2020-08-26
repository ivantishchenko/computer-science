class Solution:
    def dominantIndex(self, nums):
        max_val = max(nums)
        max_idx = nums.index(max_val)

        nums.pop(max_idx)

        for el in nums:
            if el * 2 > max_val:
                return -1

        return max_idx
