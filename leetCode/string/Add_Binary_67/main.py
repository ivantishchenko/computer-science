class Solution:
    def addBinary(self, a, b):
        w = 1
        num1 = 0
        for c in reversed(a):
            num1 += w * int(c)
            w *= 2

        w = 1
        num2 = 0
        for c in reversed(b):
            num2 += w * int(c)
            w *= 2

        res = num1 + num2

        res_str = []
        while res > 0:
            res_str.append(str(res % 2))
            res = res // 2

        res_str.reverse()

        return ''.join(res_str) if res_str else '0'

a = Solution()
out = a.addBinary("11", "1")
pass