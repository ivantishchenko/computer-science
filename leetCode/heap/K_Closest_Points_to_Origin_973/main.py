import heapq

class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        max_heap = []
        for p in points:
            heapq.heappush(max_heap, (-(p[0] ** 2 + p[1] ** 2), p))
            if len(max_heap) > K:
                heapq.heappop(max_heap)

        return [p[1] for p in max_heap]