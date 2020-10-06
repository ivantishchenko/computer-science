import sys

class Solution:
    def __init__(self):
        self.memo = {}

    def helper(self, coin_sum, coins):
        if coin_sum == 0:
            return 0
        if coin_sum < 0:
            return sys.maxsize

        if coin_sum in self.memo:
            return self.memo[coin_sum]

        res = sys.maxsize
        for c in coins:
            res = min(res, self.helper(coin_sum - c, coins) + 1)

        self.memo[coin_sum] = res
        return res


    def coinChange(self, coins, amount):
        res = self.helper(amount, coins)
        return -1 if res == sys.maxsize else res

a = Solution()
out = a.coinChange([1, 2, 5], 11)
print(out)