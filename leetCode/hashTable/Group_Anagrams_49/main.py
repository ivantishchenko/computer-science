class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_map = {}
        for word in strs:
            key = [0] * 26
            for letter in word:
                key[ord(letter) - ord('a')] += 1
            key = tuple(key)
            if key not in anagram_map:
                anagram_map[key] = [word]
            else:
                anagram_map[key].append(word)
        return list(anagram_map.values())

    def groupAnagrams_sort(self, strs: List[str]) -> List[List[str]]:
        anagram_map = {}
        for w in strs:
            key = "".join(sorted(w))
            if key not in anagram_map:
                anagram_map[key] = [w]
            else:
                anagram_map[key].append(w)
        return list(anagram_map.values())

