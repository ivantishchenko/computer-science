class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        prev_row = [1]
        if not rowIndex:
            return prev_row
        for i in range(rowIndex + 1):
            curr_row = [1]

            for j in range(i - 1):
                curr_row.append(prev_row[j] + prev_row[j + 1])

            curr_row.append(1)
            prev_row = curr_row

        return prev_row