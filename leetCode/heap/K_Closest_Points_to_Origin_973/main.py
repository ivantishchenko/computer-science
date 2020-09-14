import heapq
import random


class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        dist = lambda p: p[0] ** 2 + p[1] ** 2
        n = len(points)

        def partition(start, end):
            pivot_idx = random.randint(start, end)
            points[end], points[pivot_idx] = points[pivot_idx], points[end]

            j = start
            pivot = dist(points[end])
            for i in range(start, end):
                if dist(points[i]) <= pivot:
                    points[i], points[j] = points[j], points[i]
                    j += 1
            points[end], points[j] = points[j], points[end]
            return j

        def quick_select(start, end, K):
            if start < end:
                pivot_idx = partition(start, end)

                if pivot_idx > K:
                    quick_select(start, pivot_idx - 1, K)
                elif pivot_idx < K:
                    quick_select(pivot_idx + 1, end, K)
                else:
                    return

        quick_select(0, n - 1, K)
        return points[:K]

    def kClosest_heap(self, points: List[List[int]], K: int) -> List[List[int]]:
        max_heap = []
        for p in points:
            heapq.heappush(max_heap, (-(p[0] ** 2 + p[1] ** 2), p))
            if len(max_heap) > K:
                heapq.heappop(max_heap)

        return [p[1] for p in max_heap]