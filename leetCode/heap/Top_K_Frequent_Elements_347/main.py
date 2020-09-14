import heapq
import random

from collections import Counter


class Solution:
    def partition(self, start, end, keys, freq):
        pivot_index = random.randint(start, end)
        pivot = freq[keys[pivot_index]]
        keys[pivot_index], keys[end] = keys[end], keys[pivot_index]
        j = start
        for i in range(start, end):
            if freq[keys[i]] <= pivot:
                keys[j], keys[i] = keys[i], keys[j]
                j += 1
        keys[end], keys[j] = keys[j], keys[end]
        return j

    def quick_select(self, start, end, k_idx, keys, freq):
        if start < end:
            pivot_index = self.partition(start, end, keys, freq)
            if k_idx < pivot_index:
                self.quick_select(start, pivot_index - 1, k_idx, keys, freq)
            elif k_idx > pivot_index:
                self.quick_select(pivot_index + 1, end, k_idx, keys, freq)
            else:
                return

    def topKFrequent(self, nums, k):
        freq = Counter(nums)
        keys = list(freq.keys())
        n = len(keys)
        self.quick_select(0, n - 1, n - k, keys, freq)
        return keys[n - k:]

    # quick_select
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = Counter(nums)
        keys_list = list(freq.keys())

        n = len(keys_list)
        self.quick_select(0, n - 1, freq, keys_list, n - k)
        return keys_list[n - k:]

    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # O(1) time
        if k == len(nums):
            return nums
        # O(N) time
        count = Counter(nums)
        # O(N log k) time
        return heapq.nlargest(k, count.keys(), key=count.get)

    def topKFrequent_naive(self, nums: List[int], k: int) -> List[int]:
        count_map = {}
        for el in nums:
            if el not in count_map:
                count_map[el] = 1
            else:
                count_map[el] += 1

        max_heap = []
        for el, count in count_map.items():
            heapq.heappush(max_heap, (-count, el))

        return [pair[1] for pair in [heapq.heappop(max_heap) for _ in range(k)]]

    def topKFrequent_prop(self, nums: List[int], k: int) -> List[int]:
        count_map = {}
        for el in nums:
            if el not in count_map:
                count_map[el] = 1
            else:
                count_map[el] += 1

        min_heap = []
        for el, count in count_map.items():
            heapq.heappush(min_heap, (count, el))
            if len(min_heap) > k:
                heapq.heappop(min_heap)

        return [pair[1] for pair in [heapq.heappop(min_heap) for _ in range(k)]]