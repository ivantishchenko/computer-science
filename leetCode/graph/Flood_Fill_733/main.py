class Solution:
    def dfs(self, image, x, y, new_c, prev_c):
        if not self.is_inside(x, y):
            return

        if image[x][y] != prev_c or image[x][y] == new_c:
            return

        image[x][y] = new_c
        self.dfs(image, x + 1, y, new_c, prev_c)
        self.dfs(image, x - 1, y, new_c, prev_c)
        self.dfs(image, x, y + 1, new_c, prev_c)
        self.dfs(image, x, y - 1, new_c, prev_c)

    def floodFill(self, image, sr, sc, newColor):
        m, n = len(image), len(image[0])

        self.is_inside = lambda x, y: 0 <= x < m and 0 <= y < n

        self.dfs(image, sr, sc, newColor, image[sr][sc])

        return image


a = Solution()
a.floodFill([[1,1,1],[1,1,0],[1,0,1]], 1, 1, 2)
pass