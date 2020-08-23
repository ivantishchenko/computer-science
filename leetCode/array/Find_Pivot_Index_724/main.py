class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        arr_sum = sum(nums)

        left_sum = 0
        for i, num in enumerate(nums):
            right_sum = arr_sum - num - left_sum
            if right_sum == left_sum:
                return i
            left_sum += num
        return -1

    def pivotIndex_slow(self, nums: List[int]) -> int:
        l_sums = [0]
        for i in range(0, len(nums) - 1):
            l_sums.append(l_sums[i] + nums[i])

        for i in range(len(nums)):
            r_sum = sum(nums[i + 1:])
            if l_sums[i] == r_sum:
                return i

        return -1
