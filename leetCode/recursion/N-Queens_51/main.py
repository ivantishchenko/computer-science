class Solution:
    def place_queen(self, diag1, diag2, cols, row, col):
        diag1.add(row + col)
        diag2.add(row - col)
        cols[col] = row

    def remove_queen(self, diag1, diag2, cols, row, col):
        diag1.remove(row + col)
        diag2.remove(row - col)
        del cols[col]

    def is_under_attack(self, diag1, diag2, cols, row, col):
        return row + col in diag1 or row - col in diag2 or col in cols

    def backtrack(self, diag1, diag2, cols, n, row, res, pos):
        for col in range(n):
            if not self.is_under_attack(diag1, diag2, cols, row, col):
                self.place_queen(diag1, diag2, cols, row, col)
                if row == n - 1:
                    res.append([j * '.' + 'Q' + (n - 1 - j) * '.' for j in pos + [col]])
                else:
                    self.backtrack(diag1, diag2, cols, n, row + 1, res, pos + [col])
                self.remove_queen(diag1, diag2, cols, row, col)

    def solveNQueens(self, n):
        diag_set1 = set()
        diag_set2 = set()
        col_map = {}
        res_list = []
        self.backtrack(diag_set1, diag_set2, col_map, n, 0, res_list, [])
        return res_list

a = Solution()
print(a.solveNQueens(4))
