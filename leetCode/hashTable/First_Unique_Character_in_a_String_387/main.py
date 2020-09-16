class Solution:
    def firstUniqChar(self, s: str) -> int:
        count = {}
        for sym in s:
            if sym not in count:
                count[sym] = 1
            else:
                count[sym] += 1

        for i in range(len(s)):
            if count[s[i]] == 1:
                return i

        return -1