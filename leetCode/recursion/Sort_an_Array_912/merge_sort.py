class Solution:
    def sortArray(self, nums):
        if len(nums) <= 1:
            return nums

        pivot = len(nums) // 2
        left = self.sortArray(nums[:pivot])
        right = self.sortArray(nums[pivot:])
        return self.merge(left, right)

    def merge(self, left, right):
        i = j = 0
        merged = []
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                merged.append(left[i])
                i += 1
            else:
                merged.append(right[j])
                j += 1

        merged.extend(left[i:])
        merged.extend(right[j:])
        return merged

a = Solution()
res = a.sortArray([5,2,3,1])
pass