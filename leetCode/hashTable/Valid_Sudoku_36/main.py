class Solution:
    def is_valid(self, c, row, col, board):
        m, n = len(board), len(board[0])

        # col
        for i in range(m):
            if i != row and board[i][col] == c:
                return False

        # row
        for i in range(n):
            if i != col and board[row][i] == c:
                return False

        # cell
        row_0 = (row // 3) * 3
        col_0 = (col // 3) * 3

        for i in range(3):
            for j in range(3):
                if row_0 + i != row and col_0 + j != col and board[row_0 + i][col_0 + j] == c:
                    return False

        return True

    def isValidSudoku(self, board):
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] != '.':
                    if not self.is_valid(board[i][j], i, j, board):
                        return False
        return True
