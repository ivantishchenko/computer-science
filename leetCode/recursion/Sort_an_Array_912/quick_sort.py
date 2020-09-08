class Solution:
    def sortArray(self, nums):
        self.quick_sort(0, len(nums) - 1, nums)
        return nums

    def quick_sort(self, start, end, arr):
        if start < end:
            p_index = self.partition(start, end, arr)
            self.quick_sort(start, p_index - 1, arr)
            self.quick_sort(p_index + 1, end, arr)

    def partition(self, start, end, arr):
        p_index = start
        pivot = arr[end]
        for i in range(start, end):
            if arr[i] <= pivot:
                arr[p_index], arr[i] = arr[i], arr[p_index]
                p_index += 1
        arr[end], arr[p_index] = arr[p_index], arr[end]
        return p_index