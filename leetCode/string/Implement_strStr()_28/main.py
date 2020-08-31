class Solution:
    def strStr(self, haystack, needle):
        needle_len = len(needle)
        for i in range(len(haystack) - needle_len + 1):
            if haystack[i:i+needle_len] == needle:
                return i

        return -1

a = Solution()
res = a.strStr("hello", "ll")
pass