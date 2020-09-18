class Solution:
    def lengthOfLongestSubstring(self, s):
        substr = set()
        n = len(s)
        res = i = j = 0
        while i < n and j < n:
            if s[j] not in substr:
                substr.add(s[j])
                j += 1
                res = max(res, j - i)
            else:
                substr.remove(s[i])
                i += 1
        return res

    def lengthOfLongestSubstring(self, s):
        substr = {}
        n = len(s)
        res = i = 0
        for j in range(n):
            if s[j] in substr:
                i = max(i, substr[s[j]])
            substr[s[j]] = j + 1
            res = max(res, j - i + 1)

        return res
