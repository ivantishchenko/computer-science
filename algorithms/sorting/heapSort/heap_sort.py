class Solution:
    def max_heapify(self, arr, i, heap_size):
        largest_idx = i
        left = 2 * i + 1
        right = 2 * i + 2

        if left < heap_size and arr[left] > arr[largest_idx]:
            largest_idx = left

        if right < heap_size and arr[right] > arr[largest_idx]:
            largest_idx = right

        # swap needed
        if largest_idx != i:
            arr[i], arr[largest_idx] = arr[largest_idx], arr[i]
            self.max_heapify(arr, largest_idx, heap_size)


    def sortArray(self, arr):
        heap_size = len(arr)

        # Build max heap => loop over non leaves
        for i in range(heap_size//2 - 1, -1, -1):
            self.max_heapify(arr, i, heap_size)

        # iterate in reverse and keep fixing root
        for curr_size in range(heap_size - 1, 0, -1):
            # put max at the end
            arr[curr_size], arr[0] = arr[0], arr[curr_size]
            # fix the root
            self.max_heapify(arr, 0, curr_size)

        return arr
