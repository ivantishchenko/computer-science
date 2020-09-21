class Solution:
    def fourSumCount(self, A, B, C, D):
        n = len(A)
        cache = {}
        for c in range(n):
            for d in range(n):
                sum_val = C[c] + D[d]
                if sum_val not in cache:
                    cache[sum_val] = 1
                else:
                    cache[sum_val] += 1

        res = 0
        for a in range(n):
            for b in range(n):
                key = -A[a] - B[b]
                if key in cache:
                    res += cache[key]
        return res

