class Solution:
    memo = {}
    def numTrees(self, n: int) -> int:
        if n <= 1:
            self.memo[n] = 1
            return self.memo[n]
        if n in self.memo:
            return self.memo[n]
        res = 0
        for i in range(1, n + 1):
            res += self.numTrees(i - 1) * self.numTrees(n - i)
        self.memo[n] = res
        return self.memo[n]
