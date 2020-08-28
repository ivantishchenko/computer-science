class Solution:
    def generate(self, numRows):
        if not numRows:
            return []

        res = [[1]]

        for i in range(1, numRows):
            curr = [1]

            for j in range(1, len(res[i - 1])):
                curr.append(res[i - 1][j - 1] + res[i - 1][j])

            curr.append(1)
            res.append(curr)

        return res