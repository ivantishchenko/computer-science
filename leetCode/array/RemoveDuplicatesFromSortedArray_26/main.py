class Solution:
    def removeDuplicates(self, nums):
        k = 1

        for i in range(len(nums) - 1):
            if nums[i] != nums[i + 1]:
                nums[k] = nums[i + 1]
                k += 1

        return k

a = Solution()
a.removeDuplicates([1,1,2])
pass