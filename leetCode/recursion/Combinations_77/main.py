class Solution:
    def helper(self, candidates, k):
        if k == 1:
            return [[c] for c in candidates]
        res = []
        for i in range(len(candidates)):
            next_combinations = self.helper(candidates[i + 1:], k - 1)
            for c in next_combinations:
                res.append([candidates[i]] + c)
        return res

    def combine(self, n, k):
        candidates = list(range(1, n + 1))
        return self.helper(candidates, k)


solver = Solution()
out = solver.combine(4, 2)
print(out)