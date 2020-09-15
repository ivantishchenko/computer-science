from heapq import heappop, heappush

class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = []

    def addNum(self, num: int) -> None:
        self.data.append(num)

    def findMedian(self) -> float:
        if len(self.data) == 1:
            return self.data[0]

        # quick select N / 2
        k = len(self.data) // 2
        max_heap = []
        for val in self.data:
            heappush(max_heap, val)
            if len(max_heap) > k + 1:
                heappop(max_heap)

        if len(self.data) % 2 == 1:
            return heappop(max_heap)
        else:
            return (heappop(max_heap) + heappop(max_heap)) / 2

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()