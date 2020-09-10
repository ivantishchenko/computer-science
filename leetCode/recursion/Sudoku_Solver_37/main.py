class Solution:
    def is_valid(self, c, row, col, board):
        m, n = len(board), len(board[0])

        # col
        for i in range(m):
            if board[i][col] == c:
                return False

        # row
        for i in range(n):
            if board[row][i] == c:
                return False

        # cell
        row_0 = (row // 3) * 3
        col_0 = (col // 3) * 3

        for i in range(3):
            for j in range(3):
                if board[row_0 + i][col_0 + j] == c:
                    return False

        return True

    def backtrack(self, board):
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] == '.':
                    for c in map(str, range(1, 10)):
                        if self.is_valid(c, i, j, board):
                            board[i][j] = c
                            if self.backtrack(board):
                                return True
                            board[i][j] = '.'
                    return False
        return True

    def solveSudoku(self, board):
        self.backtrack(board)

solver = Solution()
solver.solveSudoku([["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]])

