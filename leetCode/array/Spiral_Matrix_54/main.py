class Solution:
    def spiralOrder(self, matrix):
        if not matrix:
            return []

        m, n = len(matrix), len(matrix[0])

        def is_inside(x, y):
            return 0 <= x < m and 0 <= y < n

        res = []

        i_beg = 0
        i_end = m

        j_beg = 0
        j_end = n

        while len(res) != m * n:
            # right
            for j in range(j_beg, j_end):
                res.append(matrix[i_beg][j])
            i_beg += 1
            if len(res) == m * n:
                break

            # down
            for i in range(i_beg, i_end):
                res.append(matrix[i][j_end - 1])
            j_end -= 1
            if len(res) == m * n:
                break


            # left
            for j in range(j_end - 1, j_beg - 1, -1):
                res.append(matrix[i_end - 1][j])
            i_end -= 1
            if len(res) == m * n:
                break

            # up
            for i in range(i_end - 1, i_beg - 1, -1):
                res.append(matrix[i][j_beg])
            j_beg += 1
            if len(res) == m * n:
                break

        return res


a = Solution()
out = a.spiralOrder([
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
])
pass
