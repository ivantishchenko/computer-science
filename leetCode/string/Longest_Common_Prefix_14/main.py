class Solution:
    def longestCommonPrefix(self, strs):
        if not strs:
            return ''
        if len(strs) == 1:
            return strs[0]


        min_len = min(map(lambda x: len(x), strs))

        res = ''
        for i in range(min_len):
            for j in range(1, len(strs)):
                if strs[j][i] != strs[j - 1][i]:
                    return res
            res += strs[j][i]

        return res

a = Solution()
out = a.longestCommonPrefix(["a"])
pass