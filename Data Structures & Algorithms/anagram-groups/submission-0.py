class Solution:

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        letters = "abcdefghijklmnopqrstuvwxyz"
        seen = {}

        for string in strs:
            count = [0] * 26

            for char in string:
                letter_idx = letters.index(char)
                count[letter_idx] += 1

            key = tuple(count)

            if key not in seen:
                seen[key] = []

            seen[key].append(string)

        return list(seen.values())