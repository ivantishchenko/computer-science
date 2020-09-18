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
