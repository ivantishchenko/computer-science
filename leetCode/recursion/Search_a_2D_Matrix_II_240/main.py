class Solution:
    def searchMatrix(self, matrix, target):
        """

        Naive O(n + n)

        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False
        if len(matrix) == 1 and len(matrix[0]) == 1:
            if matrix[0][0] == target:
                return True
            else:
                return False

        x, y = 0, len(matrix[0]) - 1

        if matrix[x][y] < target:
            return self.searchMatrix(matrix[1:], target)
        elif matrix[x][y] > target:
            return self.searchMatrix([row[:-1] for row in matrix], target)
        else:
            return True

    def searchMatrix_optimized(self, matrix, target):
        """

        Naive O(n ^ 2)

        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False
        if len(matrix) == 1 and len(matrix[0]) == 1:
            if matrix[0][0] == target:
                return True
            else:
                return False

        pivot_x, pivot_y = len(matrix) // 2, len(matrix[0]) // 2

        if matrix[pivot_x][pivot_y] > target:
            tl = self.searchMatrix([row[:pivot_y] for row in matrix[:pivot_x]], target)
            bl = self.searchMatrix([row[pivot_y:] for row in matrix[:pivot_x]], target)
            tr = self.searchMatrix([row[:pivot_y] for row in matrix[pivot_x:]], target)
            return tl or tr or bl
        elif matrix[pivot_x][pivot_y] < target:
            br = self.searchMatrix([row[pivot_y:] for row in matrix[pivot_x:]], target)
            bl = self.searchMatrix([row[pivot_y:] for row in matrix[:pivot_x]], target)
            tr = self.searchMatrix([row[:pivot_y] for row in matrix[pivot_x:]], target)
            return tr or bl or br
        else:
            return True


    def searchMatrix_bf(self, matrix, target):
        """

        Naive O(n ^ 2)

        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False
        if len(matrix) == 1 and len(matrix[0]) == 1:
            if matrix[0][0] == target:
                return True
            else:
                return False

        pivot_x, pivot_y = len(matrix) // 2, len(matrix[0]) // 2

        tl = self.searchMatrix([row[:pivot_y] for row in matrix[:pivot_x]], target)
        br = self.searchMatrix([row[pivot_y:] for row in matrix[pivot_x:]], target)
        bl = self.searchMatrix([row[pivot_y:] for row in matrix[:pivot_x]], target)
        tr = self.searchMatrix([row[:pivot_y] for row in matrix[pivot_x:]], target)

        return tl or tr or bl or br


a = Solution()
res = a.searchMatrix([
    [1, 4, 7, 11, 15],
    [2, 5, 8, 12, 19],
    [3, 6, 9, 16, 22],
    [10, 13, 14, 17, 24],
    [18, 21, 23, 26, 30]
], 20)
print(res)
