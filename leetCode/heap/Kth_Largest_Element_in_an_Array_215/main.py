import heapq

class Solution:
    def findKthLargest_dc(self, nums: List[int], k: int) -> int:
        n = len(nums)

        def partition(start, end):
            j = start
            pivot = nums[end]
            for i in range(start, end):
                if nums[i] <= pivot:
                    nums[i], nums[j] = nums[j], nums[i]
                    j += 1

            nums[end], nums[j] = nums[j], nums[end]
            return j

        def quick_select(start, end, k_idx):
            if start < end:
                pivot_idx = partition(start, end)
                if pivot_idx > k_idx:
                    quick_select(start, pivot_idx - 1, k_idx)
                elif pivot_idx < k_idx:
                    quick_select(pivot_idx + 1, end, k_idx)
                else:
                    return

        quick_select(0, n - 1, n - k)
        return nums[n - k]

    def findKthLargest(self, nums: List[int], k: int) -> int:
        min_heap = []

        for el in nums:
            heapq.heappush(min_heap, el)
            if len(min_heap) > k:
                heapq.heappop(min_heap)

        return heapq.heappop(min_heap)