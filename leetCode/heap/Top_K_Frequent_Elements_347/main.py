import heapq

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
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