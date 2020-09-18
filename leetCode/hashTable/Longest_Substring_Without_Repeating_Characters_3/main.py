class Solution:
    def is_unique(self, s):
        return len(s) == len(set(s))

    def lengthOfLongestSubstring(self, s):
        for w_size in range(len(s), 0, -1):
            for i in range(len(s)):
                if i + w_size > len(s):
                    continue

                if self.is_unique(s[i:i + w_size]):
                    return w_size

        return 0
