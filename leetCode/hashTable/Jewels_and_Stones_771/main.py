class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        J = set(J)
        count = 0
        for stone in S:
            if stone in J:
                count += 1

        return count
