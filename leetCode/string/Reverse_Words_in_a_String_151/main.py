class Solution:
    def reverseWords(self, s):
        words = s.split(" ")
        words.reverse()

        res = []

        for w in words:
            if w != '':
                res.append(w.strip())
                res.append(' ')

        return ''.join(res[:-1])
        # return ' '.join(reversed(s.split()))

a = Solution()
out = a.reverseWords("a good   example")
pass