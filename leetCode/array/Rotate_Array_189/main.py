from collections import deque


class Solution:
    def rotate(self, nums, k):
        """
        Do not return anything, modify nums in-place instead.
        """
        k %= len(nums)
        def reverse(i, j):
            while i < j:
                nums[i], nums[j] = nums[j], nums[i]
                i, j = i + 1, j - 1

        reverse(0, len(nums) - 1)
        reverse(0, k - 1)
        reverse(k, len(nums) - 1)




    def rotate_1(self, nums, k):
        """
        Do not return anything, modify nums in-place instead.
        """

        for _ in range(k):
            nums.insert(0, nums.pop())

        return nums

a = Solution()
res = a.rotate([1,2,3,4,5,6,7], 3)
pass