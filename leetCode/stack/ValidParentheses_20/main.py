class Solution:
    c_dict = {')':'(', ']':'[', '}':'{'}
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c not in self.c_dict:
                stack.append(c)
            else:
                if not stack or self.c_dict[c] != stack.pop():
                    return False
        return not stack
