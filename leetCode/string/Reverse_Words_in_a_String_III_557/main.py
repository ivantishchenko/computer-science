class Solution:
    def reverseWords(self, s):
        # words = s.split()
        #
        # res = []
        # for w in words:
        #     res.append(w[::-1])
        #
        #
        # print(res)
        # return ' '.join(res)
        return ' '.join([w[::-1] for w in s.split()])

a = Solution()
LOL = a.reverseWords("Let's take LeetCode contest")
pass