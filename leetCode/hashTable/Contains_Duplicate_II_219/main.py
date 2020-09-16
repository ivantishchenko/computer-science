class Solution:
    def containsNearbyDuplicate(self, nums, k):
        num_map = {}

        for i in range(len(nums)):
            if nums[i] in num_map and i - num_map[nums[i]] <= k:
                return True
            else:
                num_map[nums[i]] = i

        return False



solver = Solution()
sol = solver.containsNearbyDuplicate([1,0,1,1],1)
pass