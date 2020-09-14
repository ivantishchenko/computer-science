import heapq
from collections import Counter
import random


class Solution:
    def parition(self, start, end, freq, keys_list):
        pivot_index = random.randint(start, end)
        pivot = freq[keys_list[pivot_index]]
        keys_list[pivot_index], keys_list[end] = keys_list[end], keys_list[pivot_index]

        j = start
        for i in range(start, end):
            if freq[keys_list[i]] <= pivot:
                keys_list[j], keys_list[i] = keys_list[i], keys_list[j]
                j += 1

        keys_list[j], keys_list[end] = keys_list[end], keys_list[j]
        return j

    def quick_select(self, start, end, freq, keys_list, k):
        if start < end:
            pivot_idx = self.parition(start, end, freq, keys_list)
            if pivot_idx > k:
                self.quick_select(pivot_idx + 1, end, freq, keys_list, k)
            elif pivot_idx < k:
                self.quick_select(start, pivot_idx - 1, freq, keys_list, k)
            else:
                return

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