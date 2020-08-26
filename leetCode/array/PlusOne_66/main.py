class Solution:
    def plusOne(self, digits):

        carry_flag = 1
        for i in range(len(digits) - 1, -1, -1):
            if carry_flag == 0:
                return digits

            digits[i] = (digits[i] + carry_flag) % 10
            carry_flag = 1 if digits[i] == 0 else 0

        return [1] + digits if carry_flag == 1 else digits