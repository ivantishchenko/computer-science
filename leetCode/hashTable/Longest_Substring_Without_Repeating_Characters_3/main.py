class Solution:
    def is_unique(self, s):
        return len(s) == len(set(s))

    def lengthOfLongestSubstring(self, s):
        if len(s) <= 1:
            return len(s)

        for w_size in range(1, len(s) + 1, 1):
            sub_found = False
            for i in range(len(s)):
                if i + w_size > len(s):
                    continue

                if self.is_unique(s[i:i + w_size]):
                    sub_found = True

            if not sub_found:
                return w_size - 1

        return len(s)
