from collections import deque


class Solution:
    moves = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    def bfs(self, matrix, i, j):
        q = deque([(i, j, 0)])
        while q:
            x, y, dist = q.popleft()
            if matrix[x][y] == 0:
                return dist

            for m_x, m_y in self.moves:
                next_x = x + m_x
                next_y = y + m_y
                if self.is_inside(next_x, next_y):
                    q.append((next_x, next_y, dist + 1))

    def updateMatrix(self, matrix):
        m, n = len(matrix), len(matrix[0])

        self.is_inside = lambda x, y: not(x < 0 or y < 0 or x >= m or y >= n)

        res = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                res[i][j] = self.bfs(matrix, i, j)

        return res