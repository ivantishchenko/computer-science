class Solution:
    def findDiagonalOrder_messy(self, matrix):
        res = []
        if not matrix:
            return res

        m, n = len(matrix), len(matrix[0])

        is_inside = lambda x, y: 0 <= x < m and 0 <= y < n

        for k in range(n):
            if k % 2 == 0:
                if k < m:
                    start_j = 0
                    start_i = k
                else:
                    start_j = k - m + 1
                    start_i = m - 1
                i, j = start_i, start_j
                while is_inside(i, j):
                    res.append(matrix[i][j])
                    i, j = i - 1, j + 1
            else:
                start_j = k
                start_i = 0
                i, j = start_i, start_j
                while is_inside(i, j):
                    res.append(matrix[i][j])
                    i, j = i + 1, j - 1

        for k in range(1, m):
            tmp = []
            i, j = k, n - 1
            # go down
            while is_inside(i, j):
                tmp.append(matrix[i][j])
                i, j = i + 1, j - 1

            # go up
            if (n - 1 + k) % 2 == 0:
                tmp.reverse()

            res.extend(tmp)

        return res


s = Solution()
out = s.findDiagonalOrder([[2,5],[8,4],[0,-1]])
pass
