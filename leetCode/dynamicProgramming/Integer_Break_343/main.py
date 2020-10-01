class Solution:
    def integerBreak(self, n: int) -> int:
        if n <= 3:
            return n - 1
        memo = {}
        return self.helper(n, memo)

    def helper(self, n, memo):
        if n == 0:
            return 1
        if n in memo:
            return memo[n]

        res = -1
        for i in range(1, n + 1):
            res = max(res, i * self.helper(n - i, memo))

        memo[n] = res
        return res