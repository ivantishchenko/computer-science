class Solution:
    def helper(self, start, n, k, nums, res):
        if k == len(nums):
            res.append(nums[:])
            return

        for i in range(start, n + 1):
            nums.append(i)
            self.helper(i + 1, n, k, nums, res)
            nums.pop()


    def combine(self, n, k):
        res = []
        self.helper(1, n, k, [], res)
        return res

solver = Solution()
out = solver.combine(4, 2)
print(out)