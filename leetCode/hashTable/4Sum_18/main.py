from collections import defaultdict


class Solution:
    def fourSum(self, nums, target):
        n = len(nums)
        res = set()
        cache = defaultdict(list)
        for a in range(n):
            for b in range(n):
                key = tuple(sorted([nums[a], nums[b]]))
                sum_key = sum(key)
                cache[sum_key].append(key)

        for a in range(n):
            for b in range(a + 1, n):
                if target - nums[a] - nums[b] in cache:
                    cache_list = cache[target - nums[a] - nums[b]]
                    for cd_key in cache_list:
                        res_tuple = tuple(sorted([nums[a], nums[b], cd_key[0], cd_key[1]]))
                        if res_tuple not in res:
                            res.add(res_tuple)
        return res
