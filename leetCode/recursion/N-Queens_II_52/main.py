class Solution:
    def place_queen(self, diag1, diag2, cols, row, col):
        diag1.add(row + col)
        diag2.add(row - col)
        cols.add(col)

    def remove_queen(self, diag1, diag2, cols, row, col):
        diag1.remove(row + col)
        diag2.remove(row - col)
        cols.remove(col)

    def is_under_attack(self, diag1, diag2, cols, row, col):
        return row + col in diag1 or row - col in diag2 or col in cols

    def backtrack(self, diag1, diag2, cols, n, row=0, count=0):
        for col in range(n):
            if not self.is_under_attack(diag1, diag2, cols, row, col):
                self.place_queen(diag1, diag2, cols, row, col)
                if row == n - 1:
                    count += 1
                else:
                    count = self.backtrack(diag1, diag2, cols, n, row + 1, count)
                self.remove_queen(diag1, diag2, cols, row, col)
        return count

    def totalNQueens(self, n):
        diag_set1 = set()
        diag_set2 = set()
        col_set = set()
        return self.backtrack(diag_set1, diag_set2, col_set, n)

a = Solution()
print(a.totalNQueens(4))