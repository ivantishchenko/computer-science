import sys

class Solution:
    def helper(self, coin_sum, coins, memo):
        if coin_sum == 0:
            return 0
        if coin_sum < 0:
            return sys.maxsize

        if memo[coin_sum - 1] != 0:
            return memo[coin_sum - 1]

        res = sys.maxsize
        for c in coins:
            res = min(res, self.helper(coin_sum - c, coins, memo) + 1)

        memo[coin_sum - 1] = res
        return res


    def coinChange(self, coins, amount):
        memo = [0] * amount
        res = self.helper(amount, coins, memo)
        return -1 if res == sys.maxsize else res

a = Solution()
out = a.coinChange([1, 2, 5], 11)
print(out)