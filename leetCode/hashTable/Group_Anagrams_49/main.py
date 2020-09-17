class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_map = {}
        for w in strs:
            key = "".join(sorted(w))
            if key not in anagram_map:
                anagram_map[key] = [w]
            else:
                anagram_map[key].append(w)
        return list(anagram_map.values())

