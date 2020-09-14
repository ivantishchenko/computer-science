import heapq
from collections import Counter


class Solution:
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