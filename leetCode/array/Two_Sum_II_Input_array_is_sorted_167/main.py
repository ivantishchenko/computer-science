class Solution:
    def twoSum(self, numbers, target):
        i, j = 0, len(numbers) - 1
        while i < j:
            curr_val = numbers[i] + numbers[j]
            if curr_val > target:
                j -= 1
            elif curr_val < target:
                i += 1
            else:
                return [i + 1, j + 1]
        return None

    def twoSum_brute(self, numbers, target):
        for i in range(len(numbers) - 1):
            for j in range(i + 1, len(numbers)):
                curr_val = numbers[i] + numbers[j]
                if curr_val > target:
                    break
                if curr_val == target:
                    return [i + 1, j + 1]
        return None

a = Solution()
res = a.twoSum([0,0,3,4], 0)
pass