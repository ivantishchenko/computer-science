class Solution:
    def findMaxConsecutiveOnes(self, nums):
        global_count = 0
        local_count = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                local_count += 1
            else:
                global_count = max(local_count, global_count)
                local_count = 0

        return max(local_count, global_count)