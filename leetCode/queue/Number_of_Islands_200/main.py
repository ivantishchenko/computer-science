class Solution:
    def bfs(self, i, j, grid):
        q = []
        q.append((i, j))
        while q:
            x, y = q.pop(0)
            for move in self.moves:
                next_x = x + move[0]
                next_y = y + move[1]
                if self.is_inside(next_x, next_y) and grid[next_x][next_y] == '1':
                    q.append((next_x, next_y))
                    grid[next_x][next_y] = '0'

    def dfs(self, i, j, grid):
        if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]):
            return
        if grid[i][j] == '0':
            return
        grid[i][j] = '0'
        self.dfs(i + 1, j, grid)
        self.dfs(i - 1, j, grid)
        self.dfs(i, j + 1, grid)
        self.dfs(i, j - 1, grid)

    def numIslands(self, grid: List[List[str]]) -> int:
        self.moves = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        self.is_inside = lambda i, j: not(i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]))

        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.bfs(i, j, grid)
                    res += 1
        return res