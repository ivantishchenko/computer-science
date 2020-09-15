import random

class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = []

    def addNum(self, num: int) -> None:
        self.data.append(num)

    def partition(self, start, end):
        j = start
        pivot = self.data[end]
        for i in range(start, end):
            if self.data[i] <= pivot:
                self.data[i], self.data[j] = self.data[j], self.data[i]
                j += 1
        self.data[end], self.data[j] = self.data[j], self.data[end]
        return j

    def quick_select(self, start, end, k_idx):
        if start < end:
            pivot_idx = self.partition(start, end)
            if pivot_idx > k_idx:
                self.quick_select(start, pivot_idx - 1, k_idx)
            elif pivot_idx < k_idx:
                self.quick_select(pivot_idx + 1, end, k_idx)
            else:
                return

    def findMedian(self) -> float:
        # quick select N / 2
        n = len(self.data)
        k = n // 2
        self.quick_select(0, n - 1, k)

        if len(self.data) % 2 == 1:
            return self.data[k]
        else:
            return (self.data[k - 1] + self.data[k]) / 2

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()