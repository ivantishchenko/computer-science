class Solution:
    def solve(self, A, B, C):
        return self.helper(C, A, B)

    def helper(self, W, vals, weights):
        n = len(vals)
        dp = [[0 for _ in range(W + 1)] for _ in range(n + 1)]
        for i in range(n + 1):
            for w in range(W + 1):
                if i == 0 or w == 0:
                    dp[i][w] = 0
                elif w - weights[i - 1] >= 0:
                    dp[i][w] = max(dp[i - 1][w - weights[i - 1]] + vals[i - 1], dp[i - 1][w])
                else:
                    dp[i][w] = dp[i - 1][w]

        return dp[n][W]

# if (W, len(vals)) in self.memo:
#    return self.memo[(W, len(vals))]

# if len(vals) == 0 or W == 0:
#    return 0

# if weights[-1] > W:
#    return self.helper(W, vals[:-1], weights[:-1])
# res = max(vals[-1] + self.helper(W - weights[-1], vals[:-1], weights[:-1]), self.helper(W, vals[:-1], weights[:-1]))
# self.memo[(W, len(vals))] = res
# return res
