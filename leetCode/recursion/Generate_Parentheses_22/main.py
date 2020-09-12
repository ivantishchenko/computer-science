class Solution:
    def is_valid(self, s):
        stack = []
        for c in s:
            if c == '(':
                stack.append(c)
            else:
                if not stack or '(' != stack.pop():
                    return False
        return not stack

    def backtrack(self, n, sol, left_count, right_count, res):
        if len(sol) == n * 2:
            res.append(''.join(sol))
            return

        if left_count < n:
            self.backtrack(n, sol + ['('], left_count + 1, right_count, res)
        if right_count < left_count:
            self.backtrack(n, sol + [')'], left_count, right_count + 1, res)

    def generateParenthesis(self, n: int):
        res = []
        self.backtrack(n, [], 0, 0, res)
        return res

a = Solution()
out = a.generateParenthesis(2)
print(out)