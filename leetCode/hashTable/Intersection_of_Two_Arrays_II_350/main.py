from collections import Counter


class Solution:
    def intersect(self, nums1, nums2):
        a, b = map(collections.Counter, (nums1, nums2))
        print((a & b))
        return list((a & b).elements())

    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        c1 = Counter(nums1)
        c2 = Counter(nums2)
        res = set(nums1) & set(nums2)

        final = []
        for el in res:
            final.extend(min(c1[el], c2[el]) * [el])

        return final