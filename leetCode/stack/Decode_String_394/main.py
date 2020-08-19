class Solution:
    def decodeString(self, s):
        res = ""
        i = 0
        while i < len(s):
            if s[i].isdigit():
                # parse scalar
                for j in range(i, len(s)):
                    if not s[j].isdigit():
                        scalar = int(s[i:j])
                        break

                # get substring star/end [*]
                stack_count = 1
                start_sub = j + 1
                for j in range(start_sub, len(s)):
                    if s[j] == '[':
                        stack_count += 1
                    elif s[j] == ']':
                        stack_count -= 1
                        # means it's not the last ]
                        if stack_count == 0:
                            end_sub = j
                            break

                # recursively parse [*] and append to res
                sub_dec = self.decodeString(s[start_sub:end_sub])
                res += scalar * sub_dec
                i = j + 1
            else:
                res += s[i]
                i += 1

        return res

a = Solution()
test = a.decodeString("3[a]2[bc]")
pass